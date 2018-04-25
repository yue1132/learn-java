package com.java8;

public class FormlaTest {
    public static void main(String[] args) {
        commonMethod();
        lambdaMethod();
        staticMethod();
    }

    private static void commonMethod() {
        System.out.println("================普通方法开始==================");
        Formula formla = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formla.calculate(100));
        System.out.println(formla.sqrt(16));

    }

    /**
     * 使用lambda表达式调用自定义抽象函数方法
     */
    private static void lambdaMethod() {
        System.out.println("================Lambda方法开始==================");
        Formula formula = (a) -> Math.sqrt(a * 100);

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));

    }

    /**
     * 使用静态方法引用使代码更简洁
     * java8允许通过使用::关键字获取方法或者构造方法的引用
     *
     */
    private static void staticMethod() {
        System.out.println("================::方法开始==================");

        Formula formula = Math::sqrt;
        System.out.println(formula.calculate(100));
    }

    /**
     * 使用::关键字引用构造函数
     */


}
