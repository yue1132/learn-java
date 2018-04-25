package com.base;

public class Char {

    public static void main(String[] args) {
//        m1();
//        m2();
        m3();
    }

    private static void m1() {
        String greeting = "Aabc";
        System.out.println(greeting.length());//代码单元数量
        int codePointCount = greeting.codePointCount(0, greeting.length());//代码点数
        System.out.println(codePointCount);
        char first = greeting.charAt(0);//返回位置为0的代码单元
        System.out.println(first);
        for (int i = 0; i < greeting.length(); i++) {
            int index = greeting.offsetByCodePoints(0, i);
            int codePoint = greeting.codePointAt(index);
            System.out.println("index = " + index + ", codePoint = " + codePoint + "," + (char) codePoint);
        }
    }

    private static void m2() {
        String sentence = "\u1D56B ";
        System.out.println(sentence.length());
        System.out.println(sentence.codePointCount(0,sentence.length()));
        for (int i = 0; i < sentence.length(); ) {
            int codePoint = sentence.codePointAt(i);
            if (Character.isSupplementaryCodePoint(codePoint)) {
                i += 2;
            } else {
                i++;
            }
            System.out.println(codePoint + "," + (char) codePoint);
        }
    }

    private static void m3() {
        char[] ch = Character.toChars(0x10400);
        System.out.printf("U=10400高代理字符：%04x\n", (int)ch[0]);
        System.out.printf("U=10400低代理字符：%04x\n", (int)ch[1]);

        String str = new String(ch);
        System.out.println(str);

        System.out.println("代码单元长度：" + str.length());
        System.out.println(str.codePointAt(0));//返回给定位置开始或结束的代码地点
        System.out.println(str.charAt(1));//返回给定位置的代码单元，由于未定义，返回？


        //遍历一个字符串，打印出所有字符的代码点
        str += "Hello,world!";
        System.out.println(str);

        int i = 0;
        int cp = str.codePointAt(i);

        while (i < str.length()){
            System.out.println(str.codePointAt(i) + "," + (char) str.codePointAt(i));

            if (Character.isSupplementaryCodePoint(cp)) {
                System.out.println(str.codePointAt(i) + "," + (char) str.codePointAt(i));
                i += 2;
            } else i++;

        }
    }


}
