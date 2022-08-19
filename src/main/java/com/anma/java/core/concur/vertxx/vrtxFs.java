package com.anma.java.core.concur.vertxx;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;

public class vrtxFs {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        FileSystem fs = vertx.fileSystem();
        Future<FileProps> future = fs.props("/home/malandr/IdeaProjects/java-features-examples/src/resources/text2.txt");
        future.onComplete((AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                System.out.println("File size = " + props.size());
            } else {
                System.out.println("Failure: " + ar.cause().getMessage());
            }
        });
    }
}
