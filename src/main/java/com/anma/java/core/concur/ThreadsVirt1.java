package com.anma.java.core.concur;

import java.time.Duration;
import java.time.LocalDateTime;

public class ThreadsVirt1 {

    public static void main(String[] args) {
        var now = LocalDateTime.now();

        virtual1(1000000);
//        simple(1000000);

        System.out.format(">> Action took %d", Duration.between(now, LocalDateTime.now()).toMillis());
    }

    private static void simple(long times) {
        for (int i = 0; i < times; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(">>> Thread " + Thread.currentThread().threadId());
            });
            thread.start();
        }
    }

    private static void virtual1(long times) {
        try {
            for (int i = 0; i < times; i++) {
                Thread thread = Thread.ofVirtual().start(() -> {
                    System.out.println(">>> Thread " + Thread.currentThread().threadId());
                });
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
