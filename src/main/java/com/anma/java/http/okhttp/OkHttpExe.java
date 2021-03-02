package com.anma.java.http.okhttp;

import com.google.gson.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OkHttpExe {

    public static void main(String[] args) throws IOException {

        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String todayDate = dateNow.format(formatter);
        System.out.println("Today is " + todayDate);

        testOkHttp("https://api.privatbank.ua/p24api/exchange_rates?json&date=" + todayDate);

    }

    private static void testOkHttp(String url) throws IOException {

        String jsonString = new OkHttpServiceImpl().getBody(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        // As Array
        JsonArray array = jsonObject.getAsJsonArray("exchangeRate");
        JsonObject element1 = array.get(0).getAsJsonObject();
        System.out.println("saleRateNB = " + element1.get("saleRateNB"));
        // As object
//        JsonObject exchangeRate = jsonObject.getAsJsonObject("exchangeRate");
//        System.out.println("saleRateNB = " + exchangeRate.get("saleRateNB"));

    }
}
