package com.anma.java.core.net.socket;

import javax.net.SocketFactory;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SocketExe2 {

    public static void main(String[] args) throws IOException {

        int PORT = 7072;
        ServerSocket socket = new ServerSocket(PORT);
        System.out.println(">> Server socket opened on port " + PORT);
        Socket client = socket.accept();
        System.out.println(">> Client connected");

        InputStream reader = client.getInputStream();
        OutputStream writer = client.getOutputStream();

        byte[] response = "Hello!".getBytes(StandardCharsets.UTF_8);
        writer.write(response, 0, response.length);

        byte[] bytes = reader.readAllBytes();
        System.out.println(new String(bytes));

        reader.close();
        writer.flush();
        writer.close();

        client.close();
        socket.close();
    }

}
