package com.anma.java.core.lang;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class StringExe {

    public static void main(String[] args) throws IOException {

        byte[] bytesFromURL = new URL("https://jsonplaceholder.typicode.com/users/1").openStream().readAllBytes();
        String fromURL = new String(bytesFromURL);
        System.out.println(fromURL);
        

    }

    private static void links() {
        String body = "<p><a href=\"https://bass.netcracker.com/display/RKTN/API_Gateway+AddNewSubscription\">API_Gateway AddNewSubscription</a></p>\n" +
                "<p><a href=\"https://bass.netcracker.com/display/RKTN/API_Gateway+ModifyVasOptions\" style=\"letter-spacing: 0.0px;\">API_Gateway ModifyVasOptions</a></p>\n" +
                "<p><a href=\"https://bass.netcracker.com/display/RKTN/API_Gateway+SimExchange\">API_Gateway SimExchange</a></p>\n" +
                "<p><a href=\"https://bass.netcracker.com/display/RKTN/API_Gateway+PortIn\">API_Gateway PortIn</a></p></td></tr>";

        System.out.println(body.contains("<a href=\"https://bass.netcracker.com"));
    }

    private static void misc() {

//        Split string to char array
        String[] a = "Hello there from app".split(" ");
        System.out.println(Arrays.toString(a));

//        String array to String
        String b = String.join(" ", a);
        System.out.println(b);

//        Char array to string
        String c = String.valueOf(new char[] {'H', 'e', 'l', 'l', 'o'});
        String d = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
        System.out.println(c);
        System.out.println(d);
    }

    private static void join() {

        String a = "Hello";
        String b = String.join("-", a, a, a);
        System.out.println(b);
    }

    private static void fromBytes() {

        String str1 = "Hello";
        byte[] bytes = str1.getBytes();
        String str2 = new String(bytes);
        System.out.println(str2);
    }

    private static void stringBuilder() {

        StringBuilder stringBuilder = new StringBuilder("I ");
        stringBuilder.append("love ").append("Java!");
        System.out.println(stringBuilder.toString());

        String a = "Interal";
        stringBuilder = new StringBuilder(a);
        String inserted = stringBuilder.insert(5, "nation").toString();
        System.out.println(inserted);
    }

    private static void stringMisc() {

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String hello = new String(chars);
        System.out.println(hello);

        String str2 = new String("Hello");
        System.out.println(str2);

    }

    private static void stringBuffer() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello ").append("from ").append("program");
        System.out.println(stringBuffer.toString());
    }
}
