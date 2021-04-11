package com.anma.java.exam.mthread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreadsExe {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        // via implementing Runnable
        new Thread(new Multiplier()).start();
        var secondThread = new Thread(new Multiplier());
        secondThread.setPriority(9);
        secondThread.start();
        new Thread(new Multiplier()).start();

        // via extending Thread
        Thread sub1 = new Substractor();
        sub1.start();

        // via lambda
        Runnable r1 = () -> System.out.println(String.format("Lambda: %f", Math.random() + 1));
        new Thread(r1).start();
        System.out.println(System.currentTimeMillis());

        Runnable task1 = () -> System.out.println("Exec");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(task1, 10,5, TimeUnit.SECONDS);
        ExecutorService executorService = Executors.unconfigurableExecutorService(service);

        // synchronized block
        Integer a = 5;
        synchronized (a) {
            for (int i = 0; i < a; i++) {
                System.out.println(Thread.currentThread().getId());
            }
        }

        Collections.synchronizedList(new ArrayList<>());
    }
}

class Multiplier implements Runnable {

    public void calc() {
        System.out.println((int) (Math.random() * 10));
    }

    synchronized void print2() {
    }

    @Override
    public void run() {
        calc();
    }
}

class Substractor extends Thread {

    @Override
    public void run() {
        System.out.println(Math.random() - 1);
    }
}
