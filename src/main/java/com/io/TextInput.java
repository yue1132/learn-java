package com.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * 文本输入
 */
public class TextInput {

    public static void main(String[] args) {
        //文本读入
        //1.使用Scanner类
//        method1();
        //2.使用Files.readAllBytes()工具类
        method2();
        //3.使用Files.readAllLines
        method3();
        //使用Files.lines 返回Stream（文件过大时，将行惰性处理）
        method4();
        //使用BufferReader方式
        method5();


    }

    private static void method5() {
        System.out.println("================method5==================");

        try (FileInputStream fileInputStream = new FileInputStream("d:\\database.md");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method4() {
        System.out.println("================method4:==================");

        try {
            Files.lines(Paths.get("d:\\database.md"), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method3() {
        System.out.println("================method3:==================");
        try {
//            List<String> lines = Files.readAllLines(Paths.get("d:\\database.md"));
            Path path = Paths.get("D:", "database.md");
//            System.out.println(path.isAbsolute());
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("d:\\database.md")), "UTF-8");
            System.out.println("================method2:==================");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method1() {
        System.out.println("================method1:==================");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean done = false;
            while (!done && scanner.hasNext()) {
                String next = scanner.next();
                System.out.println(next);
                if (next.equals("BYE")) {
                    done = true;
                }

            }
        }
    }

}
