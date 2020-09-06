package com.anma.java.json.json.orgjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonExe {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name", "Vasyl");
        map.put("age", "43");
        map.put("country", "Ukraine");

        Person person = new Person("Petro", 44, "Ukraine");

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject(map);
        JSONObject jsonObject3 = new JSONObject(person);
        JSONObject jsonObject4 = new JSONObject("{\"name\": \"Ignat\", \"age\": 45, \"country\": \"Ukraine\"}");

        jsonObject.put("numbers", "Andrii");

        JSONArray jsonArray = new JSONArray(Arrays.asList("one", "two", "three"));
        jsonObject3.put("names", jsonArray);

        System.out.println(jsonObject.toString());
        System.out.println(jsonObject2.toString());
        System.out.println(jsonObject3.toString());
        System.out.println(jsonObject4.toString());

    }
}

class Person {
    String name;
    int age;
    String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
