package com.anma.java.exam;

import java.util.List;
import java.util.Optional;

public class ExamStream {

    public static void main(String[] args) {
        pickNames();
    }

    public static String pickNames() {

        List<String> names = List.of("Barklay", "Barry", "Bert", "Bort");

        return names.stream()
                .filter(n -> n.contains("Bart"))
                .findAny().orElse("Not found");

    }
}
