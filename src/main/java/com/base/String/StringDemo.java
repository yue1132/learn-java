package com.base.String;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {

        //1.如果用“.”作为分隔的话必须是如下写法String.split("\\."),这样才能正确的分隔开不能用String.split(".");
        //2.如果用“|”作为分隔的话必须是如下写法String.split("\\|"),这样才能正确的分隔开不能用String.split("|");
        //3.如果在一个字符串中有多个分隔符可以用“|”作为连字符比如“acount=? and uu =? or n=?”,把三个都分隔出来可以用String.split("and|or");
        String[] str = "aaa|bbb|ccc".split("|");
        System.out.println(Arrays.toString(str));

        String[] str1 = "aaa|bbb|ccc".split("\\|");
        System.out.println(Arrays.toString(str1));

        String str2 = "account = aaa and age=22 or age=20";

        System.out.println(Arrays.toString(str2.split("and | or")));


        String url = "abcd + sssss";
        System.out.println(url);
        System.out.println(url.replaceAll("\\+","%2B"));


        String str3 = "≮ABCsdag※∑";


    }
}
