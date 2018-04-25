package com.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PathTest {
    public static void main(String[] args) {

//        ResourceBundle bundle = ResourceBundle.getBundle("test.properties");
//        System.out.println(bundle.getString("base.dir"));
//        System.out.println(bundle.getKeys());

//        Path work = Paths.get("workqqq");
//        Path abc = work.resolve("abc");
//        System.out.println(abc);
        Path path = Paths.get("d:", "fileTest", "fred", "myprog.properties");
        System.out.println(path);
        System.out.println("getParent:" + path.getParent());
        System.out.println("getRoot:" + path.getRoot());
        System.out.println("getFileName:" + path.getFileName());
        System.out.println("getFileSystem:" + path.getFileSystem());

        System.out.println("================PAth==================");

        Path path1 = Paths.get("test.properties");


        Path sourcePath = Paths.get("d:", "testFile", "testFile.zip");
        try (FileSystem fileSystem = FileSystems.newFileSystem(sourcePath, null)) {
            System.out.println(sourcePath);
            System.out.println(fileSystem.getRootDirectories());
            Files.walkFileTree(fileSystem.getPath("/"), new SimpleFileVisitor<Path>(){
                public FileVisitResult visitResult(Path file, BasicFileAttributes attrs) throws IOException{
                    System.out.println(file);
                    return FileVisitResult.CONTINUE;
                }
            });


        } catch (Exception e){
            e.printStackTrace();
        }

//        Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("test.properties"));
//            System.out.println(properties.stringPropertyNames());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        }
    }
