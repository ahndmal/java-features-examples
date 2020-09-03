package com.anma.java.core.net;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.*;

public class SocketExe {

    public static void main(String[] args) throws IOException {

//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        System.out.println(InetAddress.getLocalHost().getHostName());

        Socket socket = new Socket(InetAddress.getByName("localhost"), 8081);
        Socket socket2 = new Socket(InetAddress.getLocalHost(), 8081);
        Socket socket3 = new Socket();
        Socket socket4 = new Socket();

        socket3.bind(new InetSocketAddress("DESKTOP-MVCJ9TB", 8081));
        socket3.setKeepAlive(true);

        socket4.connect(new InetSocketAddress("DESKTOP-MVCJ9TB", 8081));
        System.out.println(socket4.getKeepAlive());

        socket2.close();
        socket4.close();

//        Javax https://docs.oracle.com/javase/8/docs/api/javax/net/SocketFactory.html
        SocketFactory socketFactory = SocketFactory.getDefault();
        Socket socket5 = socketFactory.createSocket();

    }
}
