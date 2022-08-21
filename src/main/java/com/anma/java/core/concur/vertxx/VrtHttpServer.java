package com.anma.java.core.concur.vertxx;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.net.JksOptions;

public class VrtHttpServer {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServerOptions options = new HttpServerOptions()
                .setMaxWebSocketFrameSize(1000000)
                .setLogActivity(true);
        ;
        HttpServer server = vertx.createHttpServer(options);

        server.requestHandler(request -> {
            String file = "";
            System.out.println(request.path());
            HttpServerResponse response = request.response();
            var method = request.method().name();
            if (method.equals("GET") && request.path().equals("/")) {
                MultiMap headers = request.headers();
                MultiMap params = request.params();
                response.end("Hello world");
            } else if (request.path().equals("/html")) {
                MultiMap headers = request.response().headers();
                headers.set("content-type", "text/html");
                file = "src/resources/www/index.html";
                request.response().sendFile(file);
            } else if (request.path().equals("/cats")) {
//                HttpServerResponse response = request.response();
                response.setChunked(true);

                MultiMap headers = response.headers();
                headers.set("content-type", "application/json");
                headers.set("other-header", "wibble");
                response.putHeader("Content-Length", "300");

//                request.response().write("cats");
//                request.response().write("cats two", "UTF-16");
                request.response().end("cats");
            } else if (request.path().equals("/stream")) {
                response.setChunked(true);
                request.pipeTo(response);
            }
        });

        server.listen(7766, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });

    }
}
