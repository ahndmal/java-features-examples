package com.anma.java.core.concur.vertxx;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.*;

public class VrtxOne {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        HttpClient httpClient = vertx.createHttpClient();

        Future<HttpClientRequest> request = httpClient.request(HttpMethod.GET, "");

//        request.response().putHeader("Content-Type", "text/plain").end("some text");

        HttpServerResponse response;

    }
}
