package com.anma.java.core.net.socket.org;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collections;

// https://github.com/TooTallNate/Java-WebSocket/blob/master/src/main/example/ChatServer.java
public class OrgChatServer extends WebSocketServer {

    public OrgChatServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public OrgChatServer(InetSocketAddress address) {
        super(address);
    }

    public OrgChatServer(int port, Draft_6455 draft) {
        super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake clientHandshake) {
        conn.send("Welcome to the server!"); //This method sends a message to the new client
        broadcast("new connection: " + clientHandshake
                .getResourceDescriptor()); //This method sends a message to all clients connected
        System.out.println(
                conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + " has left the room!");
        System.out.println(conn + " has left the room!");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        broadcast(message);
        System.out.println(conn + ": " + message);
    }

//    @Override
//    public void onMessage(WebSocket conn, ByteBuffer message) {
//        broadcast(message.array());
//        System.out.println(conn + ": " + message);
//    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific websocket
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        int port = 7072;    // 843 flash policy port

        try {

            port = Integer.parseInt(args[0]);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        OrgChatServer server = new OrgChatServer(port);
        server.start();
        System.out.println("ChatServer started on port: " + server.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            server.broadcast(in);
            if (in.equals("exit")) {
                server.stop(1000);
                break;
            }
        }
    }
}
