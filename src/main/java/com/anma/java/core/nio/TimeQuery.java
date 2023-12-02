package com.anma.java.core.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Pattern;

public class TimeQuery {
    // The standard daytime port
    private static int DAYTIME_PORT = 13;

    // The port we'll actually use
    private static int port = DAYTIME_PORT;

    // Charset and decoder for US-ASCII
    private static Charset charset = Charset.forName("US-ASCII");
    private static CharsetDecoder decoder = charset.newDecoder();

    // Direct byte buffer for reading
    private static ByteBuffer dbuf = ByteBuffer.allocateDirect(1024);

    // Ask the given host what time it is
    private static void query(String host) throws IOException {

        try (SocketChannel sc = SocketChannel.open()) {
            InetSocketAddress isa = new InetSocketAddress(
                    InetAddress.getByName(host), port);

            // Connect
            sc.connect(isa);

            // Read the time from the remote host. For simplicity we assume
            // that the time comes back to us in a single packet, so that we
            // only need to read once.
            dbuf.clear();
            sc.read(dbuf);

            // Print the remote address and the received time
            dbuf.flip();
            CharBuffer cb = decoder.decode(dbuf);
            System.out.print(isa + " : " + cb);

        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java TimeQuery [port] host...");
            return;
        }
        int firstArg = 0;

        // If the first argument is a string of digits then we take that
        // to be the port number
        if (Pattern.matches("[0-9]+", args[0])) {
            port = Integer.parseInt(args[0]);
            firstArg = 1;
        }

        for (int i = firstArg; i < args.length; i++) {
            String host = args[i];
            try {
                query(host);
            } catch (IOException e) {
                System.err.println(host + ": " + e);
                e.printStackTrace();
            }
        }
    }
}
