package com.anma.java.core.lang.threads;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread 1 == " + "Hello");
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread 2 == " + "Hello");
        }
    }
}

public class ThreadExe {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }
}
