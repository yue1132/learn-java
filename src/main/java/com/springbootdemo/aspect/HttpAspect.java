package com.springbootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求切面
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //@Pointcut("execution(public * com.springbootdemo.controller.*(..))")
    //public void abc (){

    //}

    @Pointcut("execution(public * com.springbootdemo.controller.GirlController.*(..)))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
//        logger.info()
//        System.out.println("==============HttpAspect Before==================");

        //获取HttpServletRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("Method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println(joinPoint.getSignature().getDeclaringType().getMethods());
//        System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println(joinPoint.getSignature().getDeclaringType().getName());
//        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        //参数
        logger.info("args={}", joinPoint.getArgs());

//        1.流程圖 2.流程说明 3.术语解释
        logger.info("2222222222222222222222");
    }

    @After("log()")
    public void doAfter() {
//        System.out.println("==============HttpAspect After===================");

//        logger.info("111111111111111");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);//返回参数值
    }
}
