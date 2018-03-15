package com.annotation.def;

import java.lang.annotation.*;
import java.util.Map;

/**
 * 自定义注解实例
 */
@Target({ElementType.METHOD,ElementType.TYPE}) // 注解的作用域， TYPE(类和接口）、LOCAL_VARIABLE(局部变量声明)、FIELD（字段声明）、PARAMETER（参数声明）、PACKAGE(包声明)、CONSTRUCTOR(构造方法声明)
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期（SOURCE源码显示,编译时会丢弃、CLASS编译时会记录到class中，运行时忽略、RUNTIME运行时存在，可以通过反射读取）
@Inherited //表示注解，表示允许子注解来继承
@Documented //生成javadoc时会包含注解信息
public @interface Description { //使用 @interface 关键字定义注解
// 注解可以没有成员，没有成员的注解称为标识注解

//    String value(); //如果注解只有一个成员，则成员名必须取名为value(),在使用时可以忽略成员名和赋值号

    String desc();//成员以无参无异常方式声明

    String author();

    int age() default 18; //可以使用default为成员变量指定一个默认值
}
