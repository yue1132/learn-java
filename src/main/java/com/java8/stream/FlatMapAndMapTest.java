package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream中map与flatMap的区别：
 * map会将一个元素变成一个新的stream
 * 但是flatMap会将结果打平，得到一个单个元素
 * <p>
 * 我们经常需要对一个流中的值进行某种形式的转换,这时可以考虑使用map方法，并传递给它一个执行转换的函数。
 * map方法，会对每一个元素应用一个函数，并将返回的值收集到一个新的流中。
 * 现在，加入你有一个函数，它返回的不是一个值，而是一个包含多个值的流,则需要是用flatMap。
 * map获取值的结构为[['a','b','c'],['m','d','w'],['k','e','t']].
 * flatMap得到的结果为['a','b','c','m','d','w','k','e','t']
 */
public class FlatMapAndMapTest {

    public static void main(String[] args) {

//        /**获取单词，并且去重**/
//        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");
//
//        //map和flatmap的区别
//        list.stream().map(item -> Arrays.stream(item.split(" ")))
//                .distinct().collect(Collectors.toList()).forEach(System.out::println);
//
//        System.out.println("==================================");
//
//        list.stream().flatMap(item->Arrays.stream(item.split(" ")))
//                .distinct().collect(Collectors.toList()).forEach(System.out::println);


        //加入我们要把单词列表["Hello","World"]，要返回列表["H","e","l", "o","W","r","d"]
        //对于需求我们可能想到的一个方法可能是这样子的：
        List<String> list = Arrays.asList("Hello", "World");
        List<String[]> list1 = list.stream()
                .map(world -> world.split(""))
                .distinct()
                .collect(Collectors.toList());
        // 传递给map方法的lambda为每个单词返回了一个String[](String 列表)。
        // 因此，map返回的流实际上是Stream<String[]>类型的。你真正想要的
        // 是用Stream<String>来表示一个字节流。因此，这样是行不通的
        System.out.println(list1);

        //Arrays.stream接收一个数组返回一个流
        List<Stream<String>> streamList = list.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("使用两次map:" + streamList);


        List<String> list2 = list.stream()
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(list2);
        System.out.println("================forEach==================");
        list.stream().forEach(System.out::println);
        System.out.println("================ForEachOrder==================");
        list.stream().map(str -> str.split("")).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(a -> System.out.printf("\t %s", a));

        System.out.println();
        String[] strings = list2.stream().toArray(String[]::new);
        System.out.println(Arrays.asList(strings));
    }
}
