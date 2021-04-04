package com.anma.java.exam.classes;

import java.util.*;

public class LinkedOne extends Object {

    int a = 123;

    {
        a = 124;
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(120));

        LinkedOne linkedOne = new LinkedOne();
        System.out.println(linkedOne.a);

//        ArrayList<String> list = new ArrayList<>();
//
//        list.forEach(System.out::println);

//     HashMap<String, Integer> pantry = new HashMap<>();
//     pantry.put("Apples", 3);
//     pantry.put("Oranges", 2);
//
//     int current = pantry.get("Apples");
//     pantry.put("Apples", current + 4);
//
//        System.out.println(pantry.get("Apples"));

    }

    public static void bad() {
        throw new Error("Error!");
    }
}
