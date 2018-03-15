package com.springbootdemo.controller;

import com.springbootdemo.domain.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @RequestMapping("hello")
    public String hello(){
        return "hello girl!";
    }
    @RequestMapping("getlist")
    public List getGirlList(Girl girl){
        logger.info("======getGirlList");
        return null;
    }
}
