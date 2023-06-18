package com.anma.java.core.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_a_WebSocket_server_in_Java */

public class MdnSockets {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        try (ServerSocket server = new ServerSocket(7072)) {

            System.out.println("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");
            Socket client = server.accept();
            System.out.println("A client connected.");

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);

            String data = scanner.useDelimiter("\\r\\n\\r\\n").next();
            Matcher matcher = Pattern.compile("^GET").matcher(data);

            if (matcher.find()) {
                Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
                match.find();
                  byte[] response = ("HTTP/1.1 101 Switching Protocols\r\n"
                        + "Connection: Upgrade\r\n"
                        + "Upgrade: websocket\r\n"
                        + "Sec-WebSocket-Accept: "
                        + Base64.getEncoder().encodeToString(
                        MessageDigest.getInstance("SHA-1")
                                .digest(
                                        (match.group(1) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")
                                                .getBytes("UTF-8"))
                )
                        + "\r\n\r\n").getBytes("UTF-8");

//                byte[] clientResp = in.readAllBytes();
//                client.close();
//                byte[] response = "Hello!".getBytes(StandardCharsets.UTF_8);

                out.write(response, 0, response.length);

                byte[] decoded = new byte[6];
                byte[] encoded = new byte[] { (byte) 198, (byte) 131, (byte) 130, (byte) 182, (byte) 194, (byte) 135 };
                byte[] key = new byte[]{(byte) 167, (byte) 225, (byte) 225, (byte) 210};
                for (int i = 0; i < encoded.length; i++) {
                    decoded[i] = (byte) (encoded[i] ^ key[i & 0x3]);
                }
                System.out.println(Arrays.toString(decoded));
                System.out.println(new String(decoded));
                System.out.println(new String(response));
                System.out.println(new String(key));
//                System.out.println(new String(clientResp));
            }
            scanner.close();
        }
    }
}





