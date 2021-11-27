package com.anma.java.exam.lambda;

import java.util.function.BiConsumer;

public class Lambda6 {
    public static void main(String[] args) {

        BiConsumer biConsumer = (a,b) -> System.out.println(a);
        biConsumer.accept(2,3);
    }
}
