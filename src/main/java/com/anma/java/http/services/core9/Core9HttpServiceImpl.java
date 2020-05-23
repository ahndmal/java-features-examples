package com.anma.java.http.services.core9;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Core9HttpServiceImpl implements Core9HttpService {

    @Override
    public HttpRequest getGETRequest(String url) throws URISyntaxException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .timeout(Duration.of(10, SECONDS))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        return httpRequest;
    }

    @Override
    public HttpRequest getPOSTRequest(String url, String body) throws URISyntaxException {

        byte[] sampleData = body.getBytes();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
//                .POST(HttpRequest.BodyProcessor.fromByteArray(sampleData))
                .build();

        return null;
    }

//    public void auth() throws URISyntaxException {
//
//        HttpResponse<String> response = HttpClient.newBuilder()
//                .authenticator(new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(
//                                "username",
//                                "password".toCharArray());
//                    }
//                }).build()
//                .send(getGETRequest(""), HttpResponse.BodyHandler.asString());
//    }

//    public HttpResponse<String> getResponse(String url) throws URISyntaxException {
//
//        HttpResponse<String> response = HttpClient.newHttpClient()
//                .send(getGETRequest(url), HttpResponse.BodyHandler.asString();
//
//        HttpHeaders responseHeaders = response.headers();
//    }
}
