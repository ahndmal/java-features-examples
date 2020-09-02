package com.anma.java.core.util.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExe {

    public static void main(String[] args) {

        List<String> people = Arrays.asList("Vasyl", "Petro", "Ignat");
        List<String> peopleMapped = people.stream()
                .map(s -> s.substring(0, s.length() - 1))
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());

//        Set<String> set = people.stream().map(people::contains).collect(Collectors.toCollection(TreeSet::new));

        peopleMapped.forEach(System.out::println);

        String joined = people.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(joined);

    }
}
