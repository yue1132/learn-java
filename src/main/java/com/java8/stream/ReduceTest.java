package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,3,4,5,9,23);

        List<String> list1 = Arrays.asList("wor","word");

//        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        Optional<Integer> reduce = list.stream().reduce(Integer::min);
        if (reduce.isPresent()){
            System.out.println(reduce.get());
        }

        Integer reduce1 = list.stream().reduce(0, Integer::max);
        System.out.println(reduce1);

        //list转数组
        Integer[] array = list.toArray(new Integer[0]);

        int sum = (int) list1.stream().mapToInt(String::length).count();
        System.out.println("+++:" + sum);
    }
}
