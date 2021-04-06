package com.anma.java.exam.lambda;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

interface LambdaInter1 {

    int calc(int a, int b);
}

public class Func1 implements LambdaInter1 {

    @Override
    public int calc(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

//        int summ = new LambdaInter1() {
//
//            @Override
//            public int calc(int a, int b) {
//                return a + b;
//            }
//        }

//        System.out.println(lam1);

        DoubleFunction<Double> area = r -> Math.PI * r * r;
        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
//        DoublePredicate<Integer, Integer> test = (x, y) -> x == y;        // Type 'java.util.function.DoublePredicate' does not have type parameters
        IntPredicate test2 = x -> x == 10;
    }
}
