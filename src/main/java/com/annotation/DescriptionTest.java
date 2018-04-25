package com.annotation;

import com.annotation.def.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 自定义注解解析测试
 */
@Description(desc = "I am class annotation!", author = "chen")
public class DescriptionTest {

    @Description(desc = "I am method annotation!", author = "chengy", age = 20)
    public String eyeColor() {
        return "blue";
    }


    public static void main(String[] args) {
        try {
            // 1. 使用类加载器加载类
            Class<?> aClass = Class.forName("com.annotation.DescriptionTest");
            // 2. 找到类上面的注解
            boolean isExist = aClass.isAnnotationPresent(Description.class);
            if (isExist) {
                // 3. 拿到注解实例
                Description d = aClass.getAnnotation(Description.class);
                System.out.println("=============Class=============desc:" + d.desc() + " author:" + d.author() +" age:"+ d.age());
            }

            // 4.拿到方法注解
            Method[] methods = aClass.getMethods();
            for (Method m : methods) {
                boolean isExistMethod = m.isAnnotationPresent(Description.class);
                if (isExistMethod) {
                    Description d = m.getAnnotation(Description.class);
                    System.out.println("===============Method=================desc:"+d.desc() +" author:"+ d.author() +" age:"+ d.age());
                }
            }

            //另外一种解析方法
            for (Method m : methods) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation des : annotations) {
                    if (des instanceof Description) {
                        Description des1 = (Description)des;
                        System.out.println("===============Method=Other================desc:"+des1.desc() +" author:"+ des1.author() +" age:"+ des1.age());
                    }
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
