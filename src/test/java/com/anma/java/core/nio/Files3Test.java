package com.anma.java.core.nio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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

    @Test
    void datesTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yy");
        LocalDate date1 = LocalDate.from(formatter.parse("15/JUL/21"));
//        LocalDate date2 = LocalDate.from(formatter.parse("15/jul/21"));
        System.out.println(date1);
//        System.out.println(date2);
    }

    @Test
    void datesTestParse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse("15/JUL/21", formatter);
        System.out.println(date1);
    }

    @Test
    void dates3() {
        LocalDate date = LocalDate.of(2021, 6, 15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
        var dateString = date.format(formatter);
        System.out.println(dateString);
    }

    @Test
    void formatDatesUpper() {
        String date = "15/JUL/21";
        String month = date.split("/")[1];
        if (Character.isUpperCase(month.charAt(1))) {
            date = date.replace(date.charAt(4), Character.toLowerCase(date.charAt(4))).replace(date.charAt(5), Character.toLowerCase(date.charAt(5)));
        }
        Assertions.assertEquals(date, "15/Jul/21");

    }



//    @Test
//    void name() {
//        BufferedReader reader = new BufferedReader(new FileReader("aaa"));
//        String currentLine;
//        if ((currentLine = reader.readLine()) != null) {
//            currentLine.trim();
//        }
//        currentLine = reader.readLine();
//    }
}