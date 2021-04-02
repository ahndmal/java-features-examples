package com.anma.java.exam.streams;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Stream1 {

    public static void main(String[] args) throws IOException {
//        System.out.println(new String(Stream1.class.getResourceAsStream("database.properties").readAllBytes()));

        var cities = List.of("Sumy", "Kyiv", "Kharkiv");

        String found = cities.stream()
                .filter(c -> c.contains("z"))
                .findAny()
                .orElse("None");
        System.out.println(found);
    }
}
