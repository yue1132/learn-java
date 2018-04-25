package com.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesTest {
    public static void main(String[] args) {

        try {
            Path testFile = Paths.get("d:", "testFile", "database.md");
            byte[] asds = Files.readAllBytes(testFile);
            String str = new String(asds, StandardCharsets.UTF_8);
            System.out.println("================Files==================");


//            List<String> strings = Files.readAllLines(testFile, StandardCharsets.UTF_8);
            Path sourcePath = Paths.get(System.getProperty("user.dir"), "test.properties");
            System.out.println(sourcePath);
//            Files.copy(sourcePath, Paths.get("d:","test.properties"), StandardCopyOption.COPY_ATTRIBUTES);

//            Files.delete(Paths.get("d:","pieMapper.xml"));
//            System.out.println(Paths.get("d", "testA"));
//            Path directories = Files.createDirectories(Paths.get("d:", "TestFiles"));
//              Files.copy(Paths.get("d:","testFile"),Paths.get("d:","TestFiles"));

//            Paths.get("d:", "TestFiles", a);
            try (Stream<Path> testFile1 = Files.list(Paths.get("d:", "workspaces"))) {
                testFile1.forEach(System.out::println);
            }


            System.out.println("================Files.walk==================");



//            Files.walk(Paths.get("d:", "workspaces"), 3).forEach(System.out::println);
            Files.walk(Paths.get("d:","testFile"))
                    .forEach( source -> {
                       if(Files.isDirectory(source)){



                       }
                    }
            );

//                    forEach(System.out::println);

//            List<String> file = Files.readAllLines(testFile);
//            file.forEach(System.out::println);

//            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
