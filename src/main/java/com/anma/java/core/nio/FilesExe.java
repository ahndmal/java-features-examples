package com.anma.java.core.nio;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class FilesExe {

    final static String text2 = "src/resources/txt/text2-new.txt";
    final static String dir = "src/resources/";
    final static String wordFile = "src/resources/word/word_example_1.docx";

    public static void main(String[] args) throws URISyntaxException, IOException {

        String url = "http://localhost:7141/download/attachments/1966081/res.txt?version=1&modificationDate=1637660124946&api=v2";
        ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(url).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("fromUrl");
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

//        File fileFromUrl = new File(URI.create(url));
//        fileFromUrl.setWritable(true);
//        FileWriter writer = new FileWriter(fileFromUrl);
//        writer.write("ADDED !!!!!");

//        FileReader reader = new FileReader(fileFromUrl);
//        System.out.println(reader.read());
    }

    private static void getFilesFromDir(String dir) throws IOException {

        Stream<Path> files = Files.list(Path.of(dir));
        files.forEach(System.out::println);
    }

    private static void readFile1(String file) throws FileNotFoundException {

        File file1 = new File(file);
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

        BasicFileAttributes attributes = Files.readAttributes(Path.of(text2), BasicFileAttributes.class);
        System.out.println(attributes.isOther());
        System.out.println(attributes.isDirectory());
    }

    private static void misc() throws IOException, URISyntaxException {

        Files.delete(Path.of(new URI("src/resources/text2-new.txt")));
        System.out.println(Files.getOwner(Path.of("src/resources/text2-new.txt")));
        System.out.println(Files.isDirectory(Path.of("src/resources/text2-new.txt")));
        System.out.println(Files.size(Path.of("src/resources/text2-new.txt")));
    }

    private static void readAllLines(String file) throws IOException {

        List<String> lines = Files.readAllLines(Path.of(file), StandardCharsets.ISO_8859_1);
        lines.forEach(System.out::println);
    }
}
