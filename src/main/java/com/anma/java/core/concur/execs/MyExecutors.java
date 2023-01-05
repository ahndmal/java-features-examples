package com.anma.java.core.concur.execs;

import java.util.concurrent.*;

public class MyExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<?> submit = executor.submit(() -> System.out.println(">> virtual"));
        Object resultNow = submit.resultNow();
        System.out.println(resultNow);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> {
            System.out.println("Hello!");
        }, 1, 5, TimeUnit.SECONDS);
    }

}
