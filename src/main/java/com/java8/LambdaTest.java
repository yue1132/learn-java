package com.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {


    public static void main(String[] args) {
        commonMethod();
        lambdaMethod();
    }

    /**
     * 普通的实现方法
     */
    private static void commonMethod() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(names);
    }

    /**
     * 使用lambda表达式实现
     */
    private static void lambdaMethod() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);

        System.out.println("==============排序前===============");
        Collections.sort(names, (String a1, String b1) -> {
            return a1.compareTo(b1);
        });
        Collections.sort(names, (String a2, String b2) -> a2.compareTo(b2));

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("==============排序后===============");

        //Predicate 是一个布尔类型的函数，该函数只有一个输入参数，包含了多种默认方法，用于处理复杂的逻辑动词
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        //Function 接口只有一个参数，并返回单一的结果。默认可以将多个函数串在一起
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println("================Function==================");
        System.out.println(backToString.apply("13"));

        //Supplier 接口产生一个给定类型的结果，与Function不同的是Supplier没有输入参数
        Supplier personSupplier = Person::new;
        System.out.println("================Supplier==================");
        System.out.println(personSupplier.get());


        //Consumers 代表了在一个输入参数上需要进行的操作
        System.out.println("================Consumers==================");
        Consumer<Person> greeter = (p) -> System.out.println("Hello," + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));

        Comparator<Person> comparator = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        System.out.println(comparator.compare(p1, p2));
        System.out.println(comparator.reversed().compare(p1, p2));


        //Optionals 不是一个函数式接口,而是一个精巧的工具接口，用来防止NullPointerException产生。
        System.out.println("================Optional==================");
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));

    }
}
