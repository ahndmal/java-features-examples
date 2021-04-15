package com.anma.java.exam.lambda;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

@FunctionalInterface
interface LambdaInter1 {

    abstract int calc(int a, int b);
    default void calcDef() {

    }
//    abstract calc2();
}

public class Func1 implements LambdaInter1 {

    @Override
    public int calc(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        LambdaInter1 lambdaInter1 = (a, b) -> a * b;
        System.out.println(lambdaInter1.calc(4, 5));


        DoubleFunction<Double> area = r -> Math.PI * r * r;
        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
//        DoublePredicate<Integer, Integer> test = (x, y) -> x == y;        // Type 'java.util.function.DoublePredicate' does not have type parameters
        IntPredicate test2 = x -> x == 10;
    }
}
