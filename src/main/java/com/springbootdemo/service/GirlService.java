package com.springbootdemo.service;

import com.springbootdemo.domain.Girl;
import com.springbootdemo.enums.ResultEnum;
import com.springbootdemo.exception.AgeException;
import com.springbootdemo.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class GirlService {

    private static final Logger logger = LoggerFactory.getLogger(GirlService.class);
    @Resource
    private GirlRepository girlRepository;

    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(20);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBB");
        girlB.setAge(21);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        System.out.println(age+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("================================girl age={}", age);
        if (age < 10) {
            throw new AgeException(ResultEnum.RRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new AgeException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            throw new AgeException(ResultEnum.UNKNOWN_ERROR);
        }

    }
}
