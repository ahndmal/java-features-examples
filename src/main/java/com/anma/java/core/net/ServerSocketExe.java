package com.anma.java.core.net;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerSocketExe {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8091);
//        serverSocket.bind((SocketAddress) InetAddress.getByName(""), 1);
        Socket socket = serverSocket.accept();

        socket.getOutputStream().write("Hello".getBytes());

        serverSocket.getChannel();
        serverSocket.close();

    }

    private static void socketFactory() throws IOException {

//        Javax https://docs.oracle.com/javase/8/docs/api/javax/net/ServerSocketFactory.html
        ServerSocketFactory factory = ServerSocketFactory.getDefault();
        ServerSocket serverSocket1 = factory.createServerSocket(8082);
        serverSocket1.close();
    }
}
