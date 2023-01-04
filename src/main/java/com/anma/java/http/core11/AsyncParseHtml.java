package com.anma.java.http.core11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncParseHtml {
    public static void main(String[] args) {
        var url1 = "https://en.wikipedia.org/wiki/Project_Waler";
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest req = HttpRequest.newBuilder()
                .GET().uri(URI.create(url1))
                .build();
        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        var htmlCnt = response.join().body();

        Document doc = Jsoup.parse(htmlCnt);
        Elements divs = doc.select("div");
        divs.stream().forEach(System.out::println);
    }
}
