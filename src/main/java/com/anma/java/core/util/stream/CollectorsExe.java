package com.anma.java.core.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExe {

    public static void main(String[] args) {

        List<String> people = Arrays.asList("Vasyl", "Petro", "Ignat");
        List<String> peopleMapped = people.stream().map(s -> s.substring(0, s.length() - 2)).collect(Collectors.toList());

        peopleMapped.forEach(System.out::println);
    }
}
