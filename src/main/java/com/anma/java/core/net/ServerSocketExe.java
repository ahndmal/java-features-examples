package com.anma.java.core.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class ServerSocketExe {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);
//        serverSocket.bind((SocketAddress) InetAddress.getByName(""), 1);
        serverSocket.getChannel();
        serverSocket.close();
    }
}
