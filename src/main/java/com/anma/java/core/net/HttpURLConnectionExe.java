package com.anma.java.core.net;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Manifest;

public class HttpURLConnectionExe {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://docs.oracle.com/javase/8/docs/api/index.html");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        Map<String, List<String>> headerFields = connection.getHeaderFields();

        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(" Header field == " + entry);
        }

        System.out.println(connection.getHeaderField("Request Method"));
        System.out.println(connection.getHeaderField(1));
        System.out.println(connection.getHeaderField("Status Code"));
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getContentType());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());

    }

    private static void fileURL(URL url) throws IOException {
        URL url2 = new URL("jar:file:/home/duke/duke.jar");
        JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
        Manifest manifest = jarConnection.getManifest();
    }
}
