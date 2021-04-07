package com.anma.java.exam.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExamLambda {

    public static void main(String[] args) {

//        Consumer<String> con1 = final String x -> System.out.println(x);
//        Consumer<String> con2 = final var x -> System.out.println(x);
//        Consumer<String> con3 = final x -> System.out.println(x);
        BiConsumer<String, String> biCon1 = (final var a, final var b) -> System.out.println(a + b);    // Correct
//        BiConsumer<String, String> biCon2 = (final var c, d) -> System.out.println(c + d);
        BiConsumer<String, String> biCon3 = (final var e, var f) -> System.out.println(e + f);      // correct
//        Function<Integer, Integer> func1 = (a, b) ->  a + b;
//        Predicate<Integer> predicate1
        Predicate<String> consumer1 = s ->  s instanceof String;
        Predicate<Integer> cons2 = i ->  i > 3;


    }
}
