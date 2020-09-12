package com.anma.java.json.json.jackson;

import com.anma.java.json.json.entity.Cat;
import com.anma.java.json.json.entity.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JacksonExe {

    private final static String path = "D:\\Programming\\java\\projects\\documents-parsing\\src\\resources\\json\\cats.json";
    private final static String jsonUrl = "https://api.privatbank.ua/p24api/exchange_rates?json&date=01.04.2020";

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        Cat[] cats = null;

        try {

            cats =  objectMapper.readValue(new File(path), Cat[].class);

            for (Cat cat : cats ) {
                System.out.println(cat.getName());
                System.out.println(cat.getAge());
            }

            Currency currency = objectMapper.readValue(new URL(jsonUrl), Currency.class);

            String currencyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency);

            System.out.println(currencyJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
