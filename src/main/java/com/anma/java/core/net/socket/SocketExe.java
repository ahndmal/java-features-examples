package com.anma.java.core.net.socket;

import javax.net.SocketFactory;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class SocketExe {

    public static void main(String[] args) throws IOException {

//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        System.out.println(InetAddress.getLocalHost().getHostName());

//        communicateWithMaxentTaggerServer("localhost", 8091, Charset.defaultCharset().toString());

        Socket echoSocket = new Socket("localhost", 8093);
        PrintWriter writer = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            writer.println(userInput);
            System.out.println("Received message from Client: " + reader.readLine());
        }
    }

    private static void sockets3() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        inputStream.close();
        System.out.println(line);

        socket.close();
    }

    private static void communicateWithMaxentTaggerServer(String host, int port, String charset) throws IOException {
        //        communicateWithMaxentTaggerServer("localhost", 8091, Charset.defaultCharset().toString());
        if (host == null) {
            host = "localhost";
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in, charset));
        System.out.println("Input some text and press RETURN to POS tag it, or just RETURN to finish.");

        for (String userInput; (userInput = stdIn.readLine()) != null && !userInput.matches("\\n?"); ) {
            try {
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), charset), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream(), charset));
                PrintWriter stdOut = new PrintWriter(new OutputStreamWriter(System.out, charset), true);
                // send material to NER to socket
                out.println(userInput);
                // Print the results of NER
                stdOut.println(in.readLine());
                while (in.ready()) {
                    stdOut.println(in.readLine());
                }
                in.close();
                socket.close();
            } catch (UnknownHostException e) {
                System.out.println("Cannot find host: ");
                System.out.println(host);
                return;
            } catch (IOException e) {
                System.out.println("I/O error in the connection to: ");
                System.out.println(host);
                return;
            }
        }
        stdIn.close();
    }

    private static void socketConnectionCHeck() throws IOException {
        Socket socket = new Socket();

        System.out.println("isConnected: " + socket.isConnected() +
                " isBound: " + socket.isBound() +
                " isClosed: " + socket.isClosed());

        socket.connect(new InetSocketAddress("google.com", 80));

        System.out.println("isConnected: " + socket.isConnected() +
                " isBound: " + socket.isBound() +
                " isClosed: " + socket.isClosed());

        socket.close();

        System.out.println("isConnected: " + socket.isConnected() +
                " isBound: " + socket.isBound() +
                " isClosed: " + socket.isClosed());
    }

    private static void sockets1() throws IOException {

        Socket socket = new Socket(InetAddress.getByName("localhost"), 8081);
        Socket socket2 = new Socket(InetAddress.getLocalHost(), 8081);
        Socket socket3 = new Socket();
        Socket socket4 = new Socket();

        socket3.bind(new InetSocketAddress("DESKTOP-MVCJ9TB", 8081));
        socket3.setKeepAlive(true);

        socket4.connect(new InetSocketAddress("DESKTOP-MVCJ9TB", 8081));
        System.out.println(socket4.getKeepAlive());

        socket2.close();
        socket4.close();

//        Javax https://docs.oracle.com/javase/8/docs/api/javax/net/SocketFactory.html
        SocketFactory socketFactory = SocketFactory.getDefault();
        Socket socket5 = socketFactory.createSocket();
    }
}
