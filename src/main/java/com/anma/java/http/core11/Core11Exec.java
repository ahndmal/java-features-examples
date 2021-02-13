package com.anma.java.http.core11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Core11Exec {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        POST();

    }

    private static void POST() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString("name: Vasyl"))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println(response.body());
    }

    private static void GET() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.privatbank.ua/p24api/exchange_rates?json&date=10.04.2020"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    private static void misc() throws IOException, InterruptedException {

        //        Synchronous request
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.privatbank.ua/p24api/exchange_rates?json&date=10.04.2020"))
                .setHeader("country", "Ukraine")
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

        System.out.println("** Headers:");
        response.headers().map().forEach((key, value) -> System.out.println(key + " ==== " + value));
    }

// Asynchronous https://mkyong.com/java/java-11-httpclient-examples/
// Multiple https://mkyong.com/java/java-11-httpclient-examples/

}
