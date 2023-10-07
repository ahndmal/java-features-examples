package com.anma.java.core.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSockEx {
    public static void main(String[] args) throws IOException {
        ServerSocket server;
        server = new ServerSocket(8082);

        System.out.println("Server has started on 127.0.0.1:8082.\r\nWaiting for a connection…");

        Socket client = server.accept();
        System.out.println("A client connected.");

        Runnable run = () -> {
            try {
                /*
Read bits 9-15 (inclusive) and interpret that as an unsigned integer. If it's 125 or less, then that's the length; you're done.
    If it's 126, go to step 2. If it's 127, go to step 3.
Read the next 16 bits and interpret those as an unsigned integer. You're done.
Read the next 64 bits and interpret those as an unsigned integer. (The most significant bit must be 0.) You're done.
                 */

                InputStream inputStream = client.getInputStream();
                OutputStream out = client.getOutputStream();
                Scanner scanner = new Scanner(inputStream, "UTF-8");

                String data = scanner.useDelimiter("\\r\\n\\r\\n").next();
                Matcher get = Pattern.compile("^GET").matcher(data);

                if (get.find()) {
                    Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
                    match.find();
                    byte[] response = ("HTTP/1.1 101 Switching Protocols\r\n"
                            + "Connection: Upgrade\r\n"
                            + "Upgrade: websocket\r\n"
                            + "Sec-WebSocket-Accept: "
                            + Base64.getEncoder().encodeToString(
                            MessageDigest.getInstance("SHA-1").digest((match.group(1) +
                                    "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes("UTF-8")))
                            + "\r\n\r\n").getBytes("UTF-8");
                    out.write(response, 0, response.length);
                }

                byte[] decoded = new byte[6];
                byte[] encoded = new byte[]{(byte) 198, (byte) 131, (byte) 130, (byte) 182, (byte) 194, (byte) 135};
                byte[] key = new byte[]{(byte) 167, (byte) 225, (byte) 225, (byte) 210};
                for (int i = 0; i < encoded.length; i++) {
                    decoded[i] = (byte) (encoded[i] ^ key[i & 0x3]);
                }
            } catch (Exception e) {

            }
        };

        run.run();

    }
}