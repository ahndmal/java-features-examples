package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

public class VrtWebCl {
    //https://vertx.io/docs/vertx-web-client/java/
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        System.out.println("clientGet");

        WebClientOptions options = new WebClientOptions()
                .setUserAgent("My-App/1.2.3");
        options.setKeepAlive(false);

//        WebClient client = WebClient.create(vertx);
        WebClient client = WebClient.create(vertx, options);
//        WebClient client = WebClient.wrap(httpClient);
        client.get(80, "example.com", "/")
                .send()
                .onSuccess(response -> {
                    System.out.println("Received response with status code" + response.statusCode());
                    System.out.println(response.body());
                })
                .onFailure(err -> System.out.println("Something went wrong " + err.getMessage()));

        clietG(client);

    }

    private static void clietG(WebClient client) {
        HttpRequest<Buffer> req = client.get(80, "google.com", "/");
        req.addQueryParam("name", "Andrii");
        // Overwrite params
//        req.uri("/some-uri?param1=param1_value&param2=param2_value");
        req.send().onComplete(b -> {
            Buffer body = b.result().body();
            System.out.println(body);
        });
    }

    public static void postAsync(WebClient client) {
        Buffer buffer = Buffer.buffer();
        buffer = buffer.appendBytes("ADDED !!!".getBytes());
        client.post(8080, "myserver.mycompany.com", "/some-uri")
                .sendBuffer(buffer)
                .onSuccess(res -> {
                    // OK
                });
    }

    public static void withAUth(WebClient client) {
        client.get(80, "example.com", "/")
                .authentication(new UsernamePasswordCredentials("myid", "mypassword"))
                //.authentication(new UsernamePasswordCredentials("myid", "mypassword"));
                .send()
                .onSuccess(response -> {
                    System.out.println("Received response with status code" + response.statusCode());
                    System.out.println(response.body());
                })
                .onFailure(err -> System.out.println("Something went wrong " + err.getMessage()));

        clietG(client);
    }
}
