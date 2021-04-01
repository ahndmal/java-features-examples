package com.anma.java.exam;

import java.util.function.UnaryOperator;

public class ExamUnary {

    public static void main(String[] args) {

//        UnaryOperator<Integer> unaOp1 = (final String x) -> x;
        UnaryOperator<Integer> unaOp2 = (var x) -> x * 2;
        UnaryOperator<Integer> unaOp3 = (x) -> x * 3;
    }
}
