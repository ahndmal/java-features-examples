package com.anma.java.core.concur;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedConExe {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(() -> {
            System.out.println("hello");
        }, 0L, 5L, TimeUnit.SECONDS);

    }
}
