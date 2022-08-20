package com.anma.java.core.concur.vertxx;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class VtClientD {

    public static void compStageOne() {
        Vertx vertx = Vertx.vertx();
        Future<String> future = vertx.createDnsClient().lookup("vertx.io");
        future.toCompletionStage().whenComplete((ip, err) -> {
            if (err != null) {
                System.err.println("Could not resolve vertx.io");
                err.printStackTrace();
            } else {
                System.out.println("vertx.io => " + ip);
            }
        });
    }

    public static void main(String[] args) {
        compStageOne();
    }

}
