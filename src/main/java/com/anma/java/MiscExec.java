package com.anma.java;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MiscExec {

    public static void main(String[] args) {

        String name = "Ostap";

        switch (name) {
            case "Petro" -> System.out.println("khmm");
            case "Ostap" -> System.out.println("ok");
        }

        int result = switch (name) {
            case "aaa" -> 10;
            case "bbb" -> 20;
            default -> 100;
        };

        System.out.println(result);

    }

}
