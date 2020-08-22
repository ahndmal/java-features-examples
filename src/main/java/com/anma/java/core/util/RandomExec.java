package com.anma.java.core.util;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class RandomExec {
    public static void main(String[] args) {

        Random random = new Random();
        DoubleStream doubleStream = random.doubles().limit(10);
        DoubleStream doubleStream2 = random.doubles();

//        doubleStream.forEach(System.out::println);
//        doubleStream2.filter(el -> el < 10).collect(Collectors.toList());

        for (int i = 0; i < 15; i++) {
            System.out.println(random.nextInt(20));
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt());
//        }
//        System.out.println(doubleStream.findFirst().getAsDouble());
    }
}
