package com.anma.java.core.lang;

import java.util.Map;
import java.util.Properties;

public class SystemTester {

    public static void main(String[] args) {

        systemEnv();

    }

    private static void propsOne() {
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("os.name"));
        System.out.println(properties.getProperty("os.arch"));
        System.out.println(properties.getProperty("java.home"));
    }

    private static void systemEnv() {
        Map<String, String> envs = System.getenv();
        Properties properties = System.getProperties();

        System.out.println("******* ENV: ");
        envs.entrySet().forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("******* Props: ");
        properties.entrySet().forEach(System.out::println);
    }
}
