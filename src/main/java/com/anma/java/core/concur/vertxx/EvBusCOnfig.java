package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.http.ClientAuth;
import io.vertx.core.net.JksOptions;

public class EvBusCOnfig {

    public void config() {
        VertxOptions options = new VertxOptions()
                .setEventBusOptions(new EventBusOptions()
                        .setSsl(true)
                        .setKeyStoreOptions(new JksOptions().setPath("keystore.jks").setPassword("wibble"))
                        .setTrustStoreOptions(new JksOptions().setPath("keystore.jks").setPassword("wibble"))
                        .setClientAuth(ClientAuth.REQUIRED)
                );

        Vertx.clusteredVertx(options, res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                EventBus eventBus = vertx.eventBus();
                System.out.println("We now have a clustered event bus: " + eventBus);
            } else {
                System.out.println("Failed: " + res.cause());
            }
        });
    }
}
