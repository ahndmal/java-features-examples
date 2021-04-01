package com.anma.java.exam.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExamLambda {

    public static void main(String[] args) {

//        Consumer<String> con1 = final String x -> System.out.println(x);
//        Consumer<String> con2 = final var x -> System.out.println(x);
//        Consumer<String> con3 = final x -> System.out.println(x);
        BiConsumer<String, String> biCon1 = (final var a, final var b) -> System.out.println(a + b);    // Correct
//        BiConsumer<String, String> biCon2 = (final var c, d) -> System.out.println(c + d);
        BiConsumer<String, String> biCon3 = (final var e, var f) -> System.out.println(e + f);      // correct

    }
}
