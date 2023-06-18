package com.anma.java.core.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 */
public class SocketEcho {
    public static void main(String[] args) throws InterruptedException {
        // 0 - port
        // 1 - number of client
        // 2 - delay
        int port = Integer.parseInt(args[0]);
        new Thread(() -> EchoServer.createServer(port)).start();
        new Thread(() -> {
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                new Thread(() -> EchoClient.createClient(port)).start();
                try {
                    Thread.sleep(Integer.parseInt(args[2]) * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

    static class EchoServer {
        static void createServer(int port) {
            System.out.println(">> Starting server on port " + port);
            try (ServerSocket serverSocket = new ServerSocket(port);) {
                while (true) {
                    try (Socket cln = serverSocket.accept();
                         PrintWriter out = new PrintWriter(cln.getOutputStream(), true);
                         BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
                        String inputLine;
                        BufferedReader clientIn = new BufferedReader(new InputStreamReader(cln.getInputStream()));
                        while ((inputLine = clientIn.readLine()) != null) {
                            System.out.printf(">> \u001b[33mServer got:\u001b[0m  %s  \n", inputLine);
                        }
                        clientIn.close();
                    }

                }
//            String sent;
//            while ((sent = stdIn.readLine()) != null) {
//                out.println(sent);
//                System.out.printf(">> \u001b[33mServer sent:\u001b[0m  %s  \n", sent);
//            }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


    static class EchoClient {
        static void createClient(int PORT) {
            String hostName = null;
            try {
                hostName = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            try (Socket echoSocket = new Socket(hostName, PORT);
                 PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(echoSocket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
            ) {
                System.out.println("> Started CLIENT on port " + PORT);
                out.printf("> Client %d sent: 'Hello !!' in %s", echoSocket.hashCode(), Thread.currentThread().getName());
//            String userInput;
//            while ((userInput = stdIn.readLine()) != null
//                    || !(userInput = stdIn.readLine()).equalsIgnoreCase("exit")) {
//                out.println(userInput);
//                System.out.println("> \u001b[35mClient sent: \u001b[0m: " + userInput + "\n");
//            }

//            String recv;
//            while ((recv = in.readLine()) != null) {
//                System.out.println("> \u001b[35mClient recieved: \u001b[0m: " + recv + "\n");
//            }

            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " + hostName);
                System.exit(1);
            }
        }
    }

}




