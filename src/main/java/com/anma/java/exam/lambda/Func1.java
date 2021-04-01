package com.anma.java.exam.lambda;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class Func1 {
    public static void main(String[] args) {

        DoubleFunction<Double> area = r -> Math.PI * r * r;
        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
//        DoublePredicate<Integer, Integer> test = (x, y) -> x == y;        // Type 'java.util.function.DoublePredicate' does not have type parameters
        IntPredicate test2 = x -> x == 10;
    }
}
