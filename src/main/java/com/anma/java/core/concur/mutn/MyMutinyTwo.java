package com.anma.java.core.concur.mutn;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyMutinyTwo {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(1);
        Multi<Integer> multi = Multi.createFrom().items(() ->
                IntStream.range(counter.get(), 1000000).boxed());
        multi.subscribe().with(
                item -> System.out.println(item),
                failure -> System.out.println("Failed with " + failure.getMessage()),
                () -> System.out.println("Completed"));


//        IntStream range = IntStream.range(1, 10000);
//        Multi.createFrom().items(range)
//                .subscribe().with(
//                        item -> System.out.println(item),
//                        failure -> System.out.println("Failed with " + failure.getMessage()),
//                        () -> System.out.println("Completed"));
    }
}
