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
}

class EchoServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 8093;
        System.out.println(">> Starting server on port " + PORT);
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket cln = serverSocket.accept();
                PrintWriter out = new PrintWriter(cln.getOutputStream(), true);
                BufferedReader clientIn = new BufferedReader(
                        new InputStreamReader(cln.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String inputLine;
            while ((inputLine = clientIn.readLine()) != null) {
                System.out.printf(">> \u001b[33mServer got:\u001b[0m  %s  \n", inputLine);
            }

            String sent;
            while ((sent = stdIn.readLine()) != null) {
                out.println(sent);
                System.out.printf(">> \u001b[33mServer sent:\u001b[0m  %s  \n", sent);
            }

        } catch (IOException e) {
            System.out.printf("Exception caught trying to listen on port %d", PORT);
            System.out.println(e.getMessage());
        }
    }
}


class EchoClient {
    final static int PORT = 8093;
    public static void main(String[] args) throws IOException {
        String hostName = InetAddress.getLocalHost().getHostName();
        try (Socket echoSocket = new Socket(hostName, PORT);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("> Started CLIENT on port " + PORT);
            String userInput;
            while ((userInput = stdIn.readLine()) != null
                    || !(userInput = stdIn.readLine()).equalsIgnoreCase("exit")) {
                out.println(userInput);
                System.out.println("> \u001b[35mClient sent: \u001b[0m: " + userInput + "\n");
            }

            String recv;
            while ((recv = in.readLine()) != null) {
                System.out.println("> \u001b[35mClient recieved: \u001b[0m: " + recv + "\n");
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}


