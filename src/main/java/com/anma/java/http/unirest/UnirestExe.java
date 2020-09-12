package com.anma.java.http.unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestExe {

    public static void main(String[] args) throws UnirestException {

//https://pokeapi.co/api/v2/pokemon/
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";

        String jsonString = getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("order"));

    }

    static HttpResponse<JsonNode> getResponse(String url) throws UnirestException {
        return Unirest.get(url).asJson();
    }

    static String getBody(String url) throws UnirestException {
        return Unirest.get(url).asJson().getBody().toString();
    }

}
