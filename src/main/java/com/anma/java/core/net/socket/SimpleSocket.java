package com.anma.java.core.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleSocket {

    public static void main(String[] args) throws IOException {

//        Socket socket = new Socket("localhost", 7071);
        Socket socket = new Socket(InetAddress.getLocalHost(), 8088);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        String command = "GET / HTTP/1.1";

        os.write(command.getBytes());
        os.flush();

        int c = 0;

        while ((c = is.read()) != -1) {
            System.out.println((char)c);
        }

        socket.close();
    }
}
