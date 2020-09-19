package com.anma.java.core.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketGeek {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started!");

        Socket client = serverSocket.accept();
        System.out.println("New client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));

        PrintWriter writer = new PrintWriter(client.getOutputStream());

        while(!reader.ready());

        while (reader.ready()) {
            System.out.println(reader.readLine());
        }

        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println();
        writer.println("<h1>Hello from Socket Client!</h1>");
        writer.flush();
    }
}
