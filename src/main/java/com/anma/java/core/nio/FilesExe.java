package com.anma.java.core.nio;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class FilesExe {

    public static void main(String[] args) throws URISyntaxException, IOException {

        getFilesFromDir("src/resources");
    }

    private static void getFilesFromDir(String dir) throws IOException {

        Stream<Path> files = Files.list(Path.of(dir));
        files.forEach(System.out::println);
    }

    private static void readFile1() throws FileNotFoundException {

        File file1 = new File("src/resources/text2-new.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        try {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fileAttributes() throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(Path.of("src/resources/text2-new.txt"), BasicFileAttributes.class);
        System.out.println(attributes.isOther());
        System.out.println(attributes.isDirectory());
    }

    private static void misc() throws IOException, URISyntaxException {

        Files.delete(Path.of(new URI("src/resources/text2-new.txt")));
        System.out.println(Files.getOwner(Path.of("src/resources/text2-new.txt")));
        System.out.println(Files.isDirectory(Path.of("src/resources/text2-new.txt")));
        System.out.println(Files.size(Path.of("src/resources/text2-new.txt")));
    }

    private static void readAllLines() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/resources/text2-new.txt"), StandardCharsets.ISO_8859_1);
        lines.forEach(System.out::println);
    }
}
