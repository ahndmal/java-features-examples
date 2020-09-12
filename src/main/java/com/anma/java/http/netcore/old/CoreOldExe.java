package com.anma.java.http.netcore.old;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class CoreOldExe {
    public static void main(String[] args) {



    }

    private static void testCoreNet(String url) throws Exception {

        String jsonString = new CoreNetServiceImpl().readUrl(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("username"));

    }
}
