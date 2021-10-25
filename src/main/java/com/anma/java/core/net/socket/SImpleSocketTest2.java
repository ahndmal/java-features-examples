package com.anma.java.core.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SImpleSocketTest2 {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(7072);
            System.out.println(">> Server is UP");

            Socket socket1 = serverSocket.accept();
            System.out.println(">> Client1 connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));

            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());

            while(reader.ready()) {
                System.out.println(reader.readLine());
//                reader.transferTo(writer);
            }
            writer.write("out");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
