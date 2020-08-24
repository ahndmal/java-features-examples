package com.anma.java.core.lang.threads;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 1 == " + "Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 2 == " + "Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExe {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello");

    }
}
