package com.anma.java.core.twenyone;

import java.time.DayOfWeek;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
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

        var day = TUESDAY;

        int j = switch (day) {
            case MONDAY  -> 0;
            case TUESDAY -> 1;
            default      -> {
                int k = day.toString().length();
                int result = 1000;
                yield result;
            }
        };

    }


    private static void switchism() {
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


    static void howMany(int k) {
        switch (k) {
            case 1  -> System.out.println("one");
            case 2  -> System.out.println("two");
            default -> System.out.println("many");
        }
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
