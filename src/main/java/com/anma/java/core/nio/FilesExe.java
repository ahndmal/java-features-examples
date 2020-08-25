package com.anma.java.core.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;

public class FilesExe {

    public static void main(String[] args) throws URISyntaxException, IOException {

//        Files.delete(Path.of(new URI("src/resources/text2-new.txt")));
        System.out.println(Files.getOwner(Path.of("src/resources/text2-new.txt")));
        System.out.println(Files.isDirectory(Path.of("src/resources/text2-new.txt")));

        System.out.println(Files.size(Path.of("src/resources/text2-new.txt")));

        List<String> lines = Files.readAllLines(Path.of("src/resources/text2-new.txt"));
        lines.forEach(System.out::println);
    }
}
