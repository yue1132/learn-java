package com.java8.stream;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);//避免我们将null写入，forEach 接收一个消费者对象，从而将操作实施到每一个map值上
        }

        map.forEach((key, val) -> System.out.println("key:" + key + ",val=" + val));

        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println("map computeIfPresent:" + map.get(3));

        map.computeIfPresent(2, (num, val) -> null);
        System.out.println(map.containsKey(2));

        map.computeIfAbsent(12, num -> "val" + num);
        System.out.println(map.get(12));

        map.forEach((key, val) -> System.out.println("key:" + key + ",val=" + val));
        map.remove(3, "val33");
        System.out.println(map.get(3));

        System.out.println(map.getOrDefault(3, "not found" + 3));

        map.merge(15, "_val900", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(15));


        System.out.println("==================================");


    }
}
