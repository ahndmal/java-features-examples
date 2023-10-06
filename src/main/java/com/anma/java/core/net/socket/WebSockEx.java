package com.anma.java.core.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSockEx {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(8082);

        Socket accept = serverSocket.accept();

        Runnable run = () -> {
            try {
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();

                /*
Read bits 9-15 (inclusive) and interpret that as an unsigned integer. If it's 125 or less, then that's the length; you're done.
    If it's 126, go to step 2. If it's 127, go to step 3.
Read the next 16 bits and interpret those as an unsigned integer. You're done.
Read the next 64 bits and interpret those as an unsigned integer. (The most significant bit must be 0.) You're done.
                 */

                String req = new String(inputStream.readAllBytes());
                System.out.println(req);

                accept.shutdownInput();
                inputStream.close();

                outputStream.write("""
                        HTTP/1.1 101 Switching Protocols
                        Upgrade: websocket
                        Connection: Upgrade
                        Sec-WebSocket-Accept: s3pPLMBiTxaQ9kYGzzhZRbK+xOo=
                        """.getBytes());

                outputStream.close();

//                accept.close();
//                serverSocket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        };
        run.run();

    }
}
