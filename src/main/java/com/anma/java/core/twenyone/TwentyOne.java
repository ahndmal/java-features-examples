package com.anma.java.core.twenyone;

import java.util.List;

import static java.util.stream.Collectors.toList;

record Person(String name, int age) {
    Person {
        System.out.println(">> initializing Person object");
    }

    public int age() {
        return this.age;
    }

}

public class TwentyOne {

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

    List<Person> findTopMerchants(List<Person> persons, int month) {
        // Local record
        record MerchantSales(Person merchant, double sales) {
        }

        return persons.stream()
                .map(person -> new MerchantSales(person, 2.0))
                .sorted((m1, m2) -> Double.compare(m2.sales(), m1.sales()))
                .map(MerchantSales::merchant)
                .collect(toList());
    }
}
