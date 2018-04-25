package com.java8;

/**
 * 函数式接口
 * 必须要有且仅有一个抽象方法声明
 * 每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。
 * 由于默认方法不是抽象的，因此你可以在你的函数式接口中任意添加默认方法
 */
@FunctionalInterface
public interface Formula {
    //抽象方法
    double calculate(int a);

    //扩展方法（为接口非抽象的方法实现）
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    //扩展方法
    default double abs(double num) {
        return Math.abs(num);
    }



//    String sdf(String b);
}
