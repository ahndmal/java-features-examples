package com.anma.java.core.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioSOckChan {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 8888);
        ssc.socket().bind(isa);


        SocketChannel accept = ssc.accept();
        ByteBuffer buff = ByteBuffer.allocate(500);
        accept.read(buff);

        System.out.println(new String(buff.array()));
    }
}
