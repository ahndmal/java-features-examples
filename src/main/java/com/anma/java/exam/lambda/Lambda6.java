package com.anma.java.exam.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Lambda6 {
    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a,b) -> System.out.println(a + " : " + b);
        biConsumer.accept("2","3");
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a * b;
//        BiPredicate<Integer, Long> biPredicate =
    }
}
