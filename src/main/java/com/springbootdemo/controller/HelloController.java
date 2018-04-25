package com.springbootdemo.controller;

import com.springbootdemo.domain.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    /**
     * 当请求包含多个对象，对象有相同属性时，系统需要设置属性属于哪个
     * http://localhost:8080/springboot/hello?girl.age=20&boy.age=21
     */
    @RequestMapping("hello")
    public String hello(Girl girl, Boy boy) {
        System.out.println("=============================hello=================");
        return girl.toString() + " " + boy.toString();
    }

    @InitBinder("girl")
    public void InitGirlBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("girl.");
    }

    @InitBinder("boy")
    public void initBoyBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("boy.");
    }

    /**
     * 绑定List数据
     * http://localhost:8080/springboot/boyList?boys[0].height=170&boys[0].age=20&boys[1].height=172&boys[1].age=25
     * http://localhost:8080/springboot/boyList?boys[0].height=170&boys[0].age=20&boys[12].height=172&boys[12].age=25
     * @return
     */
    @GetMapping("boyList")
    public String list(BoyListForm boyListForm){
        return "size:"+ boyListForm.getBoys().size() + " list:" + boyListForm.toString();
    }

    /**
     * spring对请求的Set集合支持不够友好
     * @param boySetForm
     * @return
     */
    @GetMapping("boySet")
    public String set(BoySetForm boySetForm){
        return boySetForm.toString();
    }

    /**
     * 绑定map数据
     * http://localhost:8080/springboot/boyMap?boys['X'].height=170&boys['X'].age=20&boys['Y'].height=172&boys['Y'].age=25
     * @param boyMapForm
     * @return
     */
    @GetMapping("boyMap")
    public  String map(BoyMapForm boyMapForm){
        return boyMapForm.toString();
    }

    /**
     * 绑定json数据
     * @param boy
     * @return
     */
    @GetMapping("json")
    public  String json(Boy boy){
        return boy.toString();
    }


    /**
     * 绑定xml数据
     * @param boyForXml
     * @return
     */
    @RequestMapping("xml")
    public String xml(BoyForXml boyForXml){
        System.out.println(boyForXml.toString());
        return boyForXml.toString();
    }
}
