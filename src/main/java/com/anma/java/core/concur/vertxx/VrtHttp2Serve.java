package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

public class VrtHttp2Serve {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServerOptions options = new HttpServerOptions()
                .setUseAlpn(true)
                .setSsl(true)
                .setKeyStoreOptions(new JksOptions().setPath("/path/to/my/keystore"));

        HttpServer server = vertx.createHttpServer(options);
    }
}
