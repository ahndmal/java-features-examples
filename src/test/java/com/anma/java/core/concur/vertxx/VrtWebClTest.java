package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VrtWebClTest {

    Vertx vertx;

    @BeforeEach
    void setUp() {
        vertx = Vertx.vertx();
    }

    @Test
    void clientGet() {
        System.out.println("clientGet");
        WebClientOptions options = new WebClientOptions()
                .setUserAgent("My-App/1.2.3");
        options.setKeepAlive(false);

//        WebClient client = WebClient.create(vertx);
        WebClient client = WebClient.create(vertx, options);
//        WebClient client = WebClient.wrap(httpClient);
        client
                .get(80, "example.com", "/")
                .send()
                .onSuccess(response -> System.out.println("Received response with status code" + response.statusCode()))
                .onFailure(err -> System.out.println("Something went wrong " + err.getMessage()));

// Send a HEAD request
        client
                .head(8080, "myserver.mycompany.com", "/some-uri")
                .send()
                .onSuccess(response -> System.out.println("Received response with status code" + response.statusCode()))
                .onFailure(err -> System.out.println("Something went wrong " + err.getMessage()));
    }
}