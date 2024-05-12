package com.anma.java.core.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx implements Cloneable, Runnable {

    Thread runner = null;
    ServerSocket server = null;
    Socket data = null;
    private boolean done = false;

    public synchronized void startServer(int port) throws IOException {
        if (runner == null) {
            server = new ServerSocket(port);
            runner = new Thread(this);
            runner.start();
        }
    }

    public synchronized void stopServer() {
        done = true;
        runner.interrupt();
    }

    protected synchronized boolean getDone() {
        return done;
    }

    public void run() {
        if (server != null) {
            while (!getDone()) {
                try {
                    Socket datasocket = server.accept();
                    TCPServerEx newSocket = (TCPServerEx) clone();
                    newSocket.server = null;
                    newSocket.data = datasocket;
                    newSocket.runner =
                            new Thread(newSocket);
                    newSocket.runner.start();
                } catch (Exception e) {
                }
            }
        } else {
            run(data);
        }
    }

    public void run(Socket data) {
    }
}
