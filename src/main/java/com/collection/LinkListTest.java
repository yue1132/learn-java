package com.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkListTest {
    public static void main(String[] args) {

        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");

        Iterator<String> iter = staff.iterator();
        String first = iter.next();
        String second = iter.next();
        iter.remove();

        System.out.println(staff);

    }
}
