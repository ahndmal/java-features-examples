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

//        for (int i = 0; i < 40; i++) {
//            System.out.println(random.nextInt(10));
//        }

//        random.ints(248,403, 651).forEach(System.out::println);

//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt());
//        }
//        System.out.println(doubleStream.findFirst().getAsDouble());
    }

    public static String randomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(0, alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }

    public static String randomStringWithExclamations(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = new Random().nextInt(0, alphabet.length());
            if (index < 6) {
                sb.append("!");
            } else {
                sb.append(alphabet.charAt(index));
            }
        }
        return sb.toString();
    }
}
