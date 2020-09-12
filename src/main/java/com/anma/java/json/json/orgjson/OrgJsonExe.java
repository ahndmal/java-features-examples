package com.anma.java.json.json.orgjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrgJsonExe {
    public static void main(String[] args) throws IOException {

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

        URL url = new URL("https://restcountries.eu/rest/v2/capital/tallinn");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input;
        StringBuilder stringBuilder = new StringBuilder();
        while ((input = reader.readLine()) != null) {
            stringBuilder.append(input);
        }

        JSONArray jsonArray1 = new JSONArray(stringBuilder.toString());
        JSONObject tallin = jsonArray1.getJSONObject(0);
        
        int area = tallin.getInt("area");
        String country = tallin.getString("name");

        System.out.println(area);
        System.out.println(country);

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
