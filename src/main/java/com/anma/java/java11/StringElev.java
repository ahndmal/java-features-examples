package com.anma.java.java11;

import java.util.ArrayList;
import java.util.List;

public class StringElev {

    private static void StringJava11() {
        boolean isBlank = " ".isBlank();
        "   Sonme text".strip();

        List<String> lines = new ArrayList<>();
        "This\nis\nnew\nline".lines().forEach(l -> lines.add(l));

        String repeated = "CPU ".repeat(3);

    }
}
