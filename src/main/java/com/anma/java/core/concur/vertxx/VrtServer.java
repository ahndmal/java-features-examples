package com.anma.java.core.concur.vertxx;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

public class VrtServer {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
//        NetServerOptions options = new NetServerOptions().setPort(4321);
        NetServer server = vertx.createNetServer();
        server.connectHandler(socket -> {
            socket.sendFile("src/resources/text2.txt");
            Buffer buffer = Buffer.buffer()
                    .appendFloat(12.34f)
                    .appendInt(123);
            socket.write(buffer);
            socket.write("some data");
            socket.write("some data", "UTF-16");
//            socket.handler(buff -> {
//                buff.appendInt(1111);
//                socket.write(buff);
//                System.out.println("I received some bytes: " + buff.length());
//            });

            socket.closeHandler(v -> {
                System.out.println("The socket has been closed");
            });

        });

        server.listen(1234, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });

    }
}
