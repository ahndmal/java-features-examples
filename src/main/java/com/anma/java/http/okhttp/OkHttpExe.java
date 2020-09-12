package com.anma.java.http.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;

public class OkHttpExe {
    public static void main(String[] args) {



    }

    private static void testOkHttp(String url) throws IOException {

        String jsonString = new OkHttpServiceImpl().getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));
    }
}
