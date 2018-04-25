package com.springbootdemo.controller;

import com.springbootdemo.domain.Girl;
import com.springbootdemo.properties.GirlProperties;
import com.springbootdemo.repository.GirlRepository;
import com.springbootdemo.service.GirlService;
import com.springbootdemo.util.Result;
import com.springbootdemo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Resource
    private GirlRepository girlRepository;

    @Resource
    private GirlService girlService;

    @Resource
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello() {
//        logger.info("hello girl!" + girlProperties);
//        return null;
//    }

    @RequestMapping("getlist")
    public List getGirlList() {
        logger.info("======getGirlList");
        return null;
    }

    /**
     * 获取girls列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls() {

        return girlRepository.findAll();
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 添加一条记录
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());
        @Valid Girl girl1 = girlRepository.save(girl);
        return ResultUtil.success(girl1);
    }

    /**
     * 修改girl
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除girl
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

   @PostMapping(value="/girls/two")
    public void girlsTwo() {
        girlService.insertTwo();
    }


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);

    }

}
