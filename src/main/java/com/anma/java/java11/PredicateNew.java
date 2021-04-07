package com.anma.java.java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNew {

    public static void main(String[] args) {

//        (Predicate<String>) month -> month.startsWith("M")).negate();

        List<String> months = List.of("January", "February", "March");
        List<String> filteredMonths = months
                .stream()
                .filter(Predicate.not(month -> month.startsWith("M")))
                .collect(Collectors.toList());
        List.of("January", "February").equals(filteredMonths);
    }
}
