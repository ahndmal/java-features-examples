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

class EchoClient {

    public static void main(String[] args) throws IOException {

//        if (args.length != 2) {
//            System.err.println(
//                    "Usage: java EchoClient <host name> <port number>");
//            System.exit(1);
//        }

//        String hostName = "DESKTOP-MVCJ9TB";
//        String hostName = "localhost";
        String hostName = InetAddress.getLocalHost().getHostName();
        int portNumber = 8093;

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null || !(userInput = stdIn.readLine()).equalsIgnoreCase("exit")) {
                out.println(userInput);
                System.out.println("Socket in Client: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + InetAddress.getByName(null));
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}

class EchoServer {

    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.err.println("Usage: java EchoServer <port number>");
//            System.exit(1);
//        }

//        int portNumber = Integer.parseInt(args[0]);
        int portNumber = 8093;

        try (
                ServerSocket serverSocket = new ServerSocket(8093);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Socket in server: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
