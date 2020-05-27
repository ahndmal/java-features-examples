package com.anma.java.system;

import java.util.Properties;

public class SystemTester {

    public static void main(String[] args) {

        Properties properties = System.getProperties();

        properties.values();
//        properties.entrySet().forEach((k,v) =>System.out.println(k, v));
    }
}
