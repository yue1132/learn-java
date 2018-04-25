package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa1");
        list.add("aaa2");
        list.add("aaa4");
        list.add("bbb2");
        list.add("bbb1");
        list.add("aaa5");
        list.add("ccc");
        list.add("ccc1");

        list.stream().filter(s -> s.startsWith("b"))
                .forEach(System.out::println);

        System.out.println("================Sorted==================");

        list.stream()
                .sorted(Comparator.reverseOrder())
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("================Map==================");
        list.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("================Match==================");

        boolean flag = list.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(flag);

        System.out.println("================Reduce==================");
        Optional<String> reduceOptional = list.stream().reduce((s1, s2) -> s1 + "#" + s2);
        reduceOptional.ifPresent(System.out::println);


        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        System.out.println("================flatMap==================");
        System.out.println(playersInWorldCup2016);

        //print all player before java8
        List<String> listOfAllPlayers = new ArrayList<>();
        for (List<String> team : playersInWorldCup2016) {
            for (String name : team) {
                listOfAllPlayers.add(name);
            }
        }
        System.out.println("listOfAllPlayers:" + listOfAllPlayers);

        //do this in java8 use flatMap
        List<String> flatMapList = playersInWorldCup2016.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());

        System.out.println("flatMapList:" + flatMapList);


    }

}
