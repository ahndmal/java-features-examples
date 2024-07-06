package com.anma.java.core;

import org.junit.jupiter.api.Test;

public class NumbersTests {

    @Test
    void intTest() {
        try {
            int parsed = Integer.parseInt(" ");

            System.out.println(parsed);

            System.out.println(Integer.parseInt(""));
            System.out.println(Integer.parseInt("7"));
            System.out.println(Integer.parseInt(" "));
            System.out.println(Integer.parseInt("a"));
            System.out.println(Integer.parseInt("a5"));
            System.out.println(Integer.parseInt("14"));

        } catch (NumberFormatException e) {

        }
    }
}
