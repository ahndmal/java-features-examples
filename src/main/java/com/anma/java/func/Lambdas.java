package com.anma.java.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas {

    void lambdas() {
        final List<String> wordList = new ArrayList<>();

        // COMPILES FINE
        Runnable addItemInLambda = () -> wordList.add("adding is fine");

        // WON'T COMPILE
//        wordList = List.of("assigning", "another", "List", "is", "not");

    }

    void refinalizeReference() {
        var nonEffectivelyFinal = 1_000L;
        nonEffectivelyFinal = 9_000L;
        var finalAgain = nonEffectivelyFinal;
        Predicate<Long> isOver9000 = input -> input > finalAgain;
    }

    // Anonymous class versus lambda expression

    void anonymousVsLambda() {
        interface HelloWorld {
            String sayHello(String name);
        }
        // AS ANONYMOUS CLASS
        var helloWorld = new HelloWorld() {
            @Override
            public String sayHello(String name) {
                return "hello, " + name + "!";
            }
        };
        // AS LAMBDA
        HelloWorld helloWorldLambda = name -> "hello, " + name + "!";
    }
}
