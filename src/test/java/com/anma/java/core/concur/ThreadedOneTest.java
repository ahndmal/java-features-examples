package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadedOneTest {

    @Test
    public void testThreadingOne() {
        for (int i = 0; i < 400; i++) {
            int a = 123456;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println((a + 1_400_000 / 346 * 234567 - 1056 + 345789) / 134 * 235679823);
            };

            runnable.run();
        }
    }

}