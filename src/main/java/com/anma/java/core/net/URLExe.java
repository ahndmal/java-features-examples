package com.anma.java.core.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLExe {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://docs.oracle.com/javase/8/docs/api/index.html");

        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
//        System.out.println(url.getFile());
        System.out.println(url.getUserInfo());

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) url.getContent()));

            URLConnection connection = url.openConnection();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(reader1.readLine());

            reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
