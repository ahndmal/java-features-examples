package com.anma.java.core.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExe {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://docs.oracle.com/javase/8/docs/api/index.html");

        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getUserInfo());

    }
}
