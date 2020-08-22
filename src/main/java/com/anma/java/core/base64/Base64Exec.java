package com.anma.java.core.base64;

import java.util.Arrays;
import java.util.Base64;

public class Base64Exec {

    public static void main(String[] args) {

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode("Hello".getBytes());
        System.out.println(Arrays.toString(encoded));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(encoded);
        System.out.println(Arrays.toString(decoded));
    }
}
