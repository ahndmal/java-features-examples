package com.anma.java.core.concur.vertxx;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;

public class VrtClient {
    public static void main(String[] args) {
        String HOST = "example.com";
        Vertx vertx = Vertx.vertx();
        HttpClientOptions options = new HttpClientOptions()
                .setKeepAlive(true)
//                .setSsl(false)
                .setConnectTimeout(2000)
                .setDefaultHost(HOST);
        HttpClient client = vertx.createHttpClient(options);
        MultiMap headers = HttpHeaders
//                .set("content-type", "application/json")
                .set("other-header", "foo");
//        client.request(HttpMethod.GET,80, "https://example.com", "/", req -> {
//        client.request(options, req -> {
//
//        });
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.setHost(HOST);
        reqOptions.setMethod(HttpMethod.GET);
//        reqOptions.setHeaders(headers);
        reqOptions.setURI("/");

        client.request(reqOptions, req -> {
            System.out.println(req.succeeded());
            if (req.cause() != null) {
                System.out.println(req.cause().getMessage());
            }
            if (req.succeeded()) {
                // Connected to the server
                HttpClientRequest request = req.result();
                request.headers().addAll(headers);
                request.send(ar2 -> {
                    if (ar2.succeeded()) {
                        HttpClientResponse response = ar2.result();
                        System.out.println("Received response with status code " + response.statusCode());
                        response.end((res) -> {
                            System.out.println(res.succeeded());
                        });
                        var result = response.bodyHandler(resp -> {
                            System.out.println("HTTP response is ");
                            System.out.println(resp);
                        });
                    } else {;
                        System.out.println("Something went wrong " + ar2.cause().getMessage());
                    }
                });
            }
        });
    }
}
