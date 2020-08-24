package com.anma.java.core.lang;

import java.util.Map;
import java.util.Properties;

public class SystemTester {

    public static void main(String[] args) {

        Map<String, String> envs = System.getenv();
        Properties properties = System.getProperties();

        envs.entrySet().forEach(System.out::println);
        properties.entrySet().forEach(System.out::println);
    }
}
