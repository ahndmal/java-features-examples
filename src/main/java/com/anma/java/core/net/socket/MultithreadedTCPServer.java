package com.anma.java.core.net.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MultithreadedTCPServer extends TCPServerEx {
    public void run(Socket data) {
        try {
            DataOutputStream dos =
                    new DataOutputStream(data.getOutputStream());

            dos.writeByte(TypeServerConstants.WELCOME);

            DataInputStream dis =
                    new DataInputStream(data.getInputStream());

            while (true) {

                byte b = dis.readByte();

                if (b != TypeServerConstants.GET_STRING_REQUEST) {
                    System.out.println("Client sent unknown request " + b);
                    continue;
                }

                dos.writeByte(TypeServerConstants.GET_STRING_RESPONSE);
                dos.writeUTF("Thisisateststring");
                dos.flush();
            }
        } catch (Exception e) {
            System.out.println("Client terminating: " + e);
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        TCPServerEx ts = new TCPServerEx();
        ts.startServer(Integer.parseInt(args[0]));
        System.out.println("Server ready and waiting...");
    }
}

class TypeServerConstants {
    public final static byte WELCOME = 0;
    public final static byte GET_STRING_REQUEST = 1;
    public final static byte GET_STRING_RESPONSE = 2;
}
