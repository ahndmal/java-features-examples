package com.anma.java.core.nio;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Files3Test {

    @Test
    void wordsFromLorem() {
        try {
            List<String> words = new ArrayList<>();
            List<String> lines = Files.readAllLines(Path.of(String.format("/home/andrii/Documents/lorem%d.txt", 1)));
            lines.stream().map(l -> l.split(" ")).forEach(w -> words.addAll(Arrays.asList(w)));
            System.out.println(words.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testF2() {
        try {
            var DOC = "/home/andrii/Documents/";
            var LOREM = Path.of(DOC + "lorem1.txt");
            boolean exists = Files.exists(LOREM);
            if (!exists) {
                Path file = Files.createFile(LOREM);
                Files.writeString(file, "lorem ipsum dolor sit amet ...");
            }
            List<String> words = new ArrayList<>();
            for (int i = 1; i <= 500; i++) {
                var lines = Files.readAllLines(Path.of(String.format("%slorem%d.txt", DOC, i)));
                lines.stream().map(l -> l.split(" ")).forEach(word -> words.addAll(Arrays.asList(word)));
//                words.addAll(lines);
                System.out.println(words.size());
            }
            System.out.printf("All words: %d%n", words.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void buffReaderReadFilesTest() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/andrii/Documents/lorem1.txt"));
        String currentLine;
        if ((currentLine = reader.readLine()) != null) {
            currentLine.trim();
        }
        currentLine = reader.readLine();
    }
}