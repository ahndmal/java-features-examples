package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.file.FileSystem;

public class vrtxFs {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        FileSystem fs = vertx.fileSystem();
    }
}
