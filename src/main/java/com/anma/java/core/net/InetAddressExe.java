package com.anma.java.core.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExe {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress inetAddress = InetAddress.getLocalHost();
        InetAddress inetAddress2 = InetAddress.getByName(null);

        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress2.getHostName());
    }
}
