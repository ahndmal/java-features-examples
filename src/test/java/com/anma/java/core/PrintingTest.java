package com.anma.java.core;

import org.junit.jupiter.api.Test;

public class PrintingTest {

    @Test
    void printCOlor2() {
        System.out.println("\033[31mHello\033[0m");
        System.out.println("\033[4;44;31mHello\033[0m");
    }
}
