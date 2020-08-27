package com.anma.java.core.util.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();

        map1.put(1, "AAA");
        map1.put(2, "BBB");
        map1.replace(1, "CCC");

        Set<Map.Entry<Integer, String>> entrySet = map1.entrySet();
        System.out.println(entrySet.isEmpty());

        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
