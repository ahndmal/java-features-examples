package com.anma.java.http.services;

import com.anma.java.http.services.netcore.old.CoreNetServiceImpl;
import com.anma.java.http.services.okhttp.OkHttpServiceImpl;
import com.anma.java.http.services.unirest.UnirestServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class HttpTester {

    private static final String URL = "https://jsonplaceholder.typicode.com/users/1";

    private static void testCoreNet(String url) throws Exception {

        String jsonString = new CoreNetServiceImpl().readUrl(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));

    }

    private static void testOkHttp(String url) throws IOException {

        String jsonString = new OkHttpServiceImpl().getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));
    }

    private static void testUnirest(String url) throws UnirestException {

        String jsonString = new UnirestServiceImpl().getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));
    }


    public static void main(String[] args) throws Exception {

        System.out.println(new CoreNetServiceImpl().readUrl("https://api.privatbank.ua/p24api/exchange_rates?json&date=01.04.2020"));

//        testUnirest(URL);

//        new UnirestServiceImpl().getResponse(URL).getHeaders().forEach((k, v) -> System.out.println(k + " ======= " + v));

//        System.out.println(new OkHttpServiceImpl().getResponse(URL).message());

    }
}
