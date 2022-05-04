package com.anma.java.misc;

import java.util.*;

public class MapsMisc1 {

    private final static Map<String, List<String>> CITIES;

    static {
        CITIES = new HashMap<>();
        CITIES.put("China", Arrays.asList("Hong Kong"));
        CITIES.put("Germany", Arrays.asList("Munich", "Hamburg"));
    }

    public static void main(String[] args) {

        System.out.println(CITIES.keySet());
        var encoded = Base64.getEncoder().encodeToString("dfrF3rfF".getBytes());
        System.out.println(encoded);
        var decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println(decoded);
    }
}
