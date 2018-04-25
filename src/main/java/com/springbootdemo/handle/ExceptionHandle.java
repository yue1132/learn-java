package com.springbootdemo.handle;

import com.springbootdemo.exception.AgeException;
import com.springbootdemo.util.Result;
import com.springbootdemo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    //    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
//    private static final Logger logger = Logger.getLogger(ExceptionHandle.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof AgeException) {
            AgeException ageException = (AgeException) e;
            return ResultUtil.error(ageException.getCode(), ageException.getMessage());
        }
        logger.error("【系统异常】", e);
        return ResultUtil.error(-1, "未知错误");
    }
}
