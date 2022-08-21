package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

public class VrtHttpServer {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServerOptions options = new HttpServerOptions()
                .setMaxWebSocketFrameSize(1000000)
                .setLogActivity(true);;
        HttpServer server = vertx.createHttpServer(options);
        server.listen(7766, "localhost");

    }
}
