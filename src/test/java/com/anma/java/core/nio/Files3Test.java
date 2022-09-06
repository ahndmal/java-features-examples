package com.anma.java.core.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Files3Test {

    @Test
    void testF2() {
        try {
            List<String> words = new ArrayList<>();
            for (int i = 1; i < 19; i++) {
                var lines = Files.readAllLines(Path.of(String.format("/home/malandr/Documents/lorem%d.txt", i)));
                lines.stream().map(l -> l.split(" ")).forEach(w -> words.addAll(Arrays.asList(w)));
//                words.addAll(lines);

            }
            System.out.println(words.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}