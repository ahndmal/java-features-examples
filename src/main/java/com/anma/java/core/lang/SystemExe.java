package com.anma.java.core.lang;

import java.util.Map;
import java.util.Properties;

public class SystemExe {

    public static void main(String[] args) {

        // idea env
        System.out.println(System.getenv("simba"));
        System.out.println(System.getenv("run1"));

        // OS Env
        System.out.println("\ud83c\udf2b");
        System.out.println("\ud83d\udc6f");
        System.out.println(System.getenv("murz"));
        System.out.println(System.getenv("SHLVL "));
        System.out.println(System.getenv("java.home"));
        System.out.println(System.getenv("JOURNAL_STREAM"));
        System.out.println();
        // OS Props
        System.out.println(System.getProperty("murz"));
        System.out.println(System.getProperty("JOURNAL_STREAM"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("simba"));

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
