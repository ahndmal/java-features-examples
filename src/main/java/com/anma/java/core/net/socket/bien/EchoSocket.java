package com.anma.java.core.net.socket.bien;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("echo")
public class EchoSocket {

    private Session session;

    @OnOpen
    public void connect(Session session) {
        this.session = session;
        System.out.println(">> Session " + session);
    }

    @OnClose
    public void close() {
        this.session = null;
        System.out.println(">> Session closed");
    }

    @OnMessage
    public void message(String msg) {
        System.out.println(">> Message = " + msg);
        this.session.getAsyncRemote().sendText("> Echo " + msg);
    }
}
