package com.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileInputStreamTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
//       redFile("d:\\database.md");
//        redFile("d:\\pieMapper.xml");

//        readZip("d:\\testFile\\testFile.zip");

    }

    private static void readZip(String zipName) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println(entry.getName());
                zin.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用带资源的try语句读取文件
     * <p>
     * try(Resoutce res = ...){
     * work with res
     * }
     * try 块退出时会自动调用res.close();
     */
    private static void redFile(String path) {
//        try(Scanner in = new Scanner(new FileInputStream(path), "GBK")){
//           while (in.hasNext()){
//               System.out.println(in.next());
//           }
//        } catch(Exception e){
//            e.printStackTrace();
//        }

//        Files.readAllBytes()

//        Charset.availableCharsets().entrySet().forEach(a -> System.out.println(a));

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "GBK"))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }

//            in.lines().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
