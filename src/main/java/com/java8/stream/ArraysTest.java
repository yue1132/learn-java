package com.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysTest {

    public static void main(String[] args) {
        String[] str = new String[]{"aa", "ss", "bbb", "hello", "134", "2434"};
        String[] str1 = new String[str.length];

        List<String> list = Arrays.asList(str);
        System.out.println(list);
        list.sort((a,b) -> a.compareTo(b));
        List<String> list1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("list1:"+list1);

        System.out.println(list);

        System.out.println(Arrays.toString(str));
        Arrays.sort(str);
        System.out.println("================Arrays.sort==================");

        System.out.println(Arrays.toString(str));
        Arrays.sort(str, Comparator.naturalOrder());
        System.out.println(Arrays.toString(str));

        Arrays.sort(str, Comparator.reverseOrder());
        System.out.println(Arrays.toString(str));

        System.out.println("================开始==================");

        System.out.println(Arrays.toString(str));
        int result = binarySearch(str, 0, str.length, "ss");
        System.out.println(result);
    }

    public static int binarySearch(Object[] a, int fromIndex, int toIndex, Object key) {
        int lower = fromIndex;
        int high = toIndex - 1;

        while (lower <= high) {
            int mid = (lower + high) >>> 1;
            Comparable midVal = (Comparable) a[mid];
            int cmp = midVal.compareTo(key);
            if (cmp < 0) {
                lower = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -(lower + 1);
    }
}
