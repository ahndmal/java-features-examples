package com.anma.java.core.concur;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

public class ThreadsCounter {
    public static void main(String[] args) {

        // usual
        try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
            IntStream.range(0, 100_000).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                System.out.println(i);
                return i;
            }));
        }

        // virtual
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 100_000).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                System.out.println(i);
                return i;
            }));
        }
    }

    private static void countVirtualThreads() {
        var counter = new AtomicInteger();
        while (true) {
            Thread.startVirtualThread(() -> {
                int count = counter.incrementAndGet();
                System.out.println("Thread count = " + count);
                LockSupport.park();
            });
        }
    }

    private static void countThreads() {
        var counter = new AtomicInteger();
        while (true) {
            new Thread(() -> {
                int count = counter.incrementAndGet();
                System.out.println("Thread count = " + count);
                LockSupport.park();
            }).start();
        }
    }
}
