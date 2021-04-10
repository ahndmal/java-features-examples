package com.anma.java.exam.mthread;

public class MultiThreadsExe {
    public static void main(String[] args) {

        // via implementing Runnable
        new Thread(new Multiplier()).start();
        new Thread(new Multiplier()).start();
        new Thread(new Multiplier()).start();

        // via extending Thread
        Thread sub1 = new Substractor();
        sub1.start();

        // via lambda
        Runnable r1 = () -> System.out.println(String.format("Lambda: %f", Math.random() + 1));
        new Thread(r1).start();


    }
}

class Multiplier implements Runnable {

    public void calc() {
        System.out.println((int) (Math.random() * 10));
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
