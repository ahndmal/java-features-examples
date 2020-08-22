package com.anma.java.core.util.base64;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Base64Exec {

    public static void main(String[] args) {

        encode1();
    }

    private static void encode2() {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode("Hello".getBytes());
        System.out.println(Arrays.toString(encoded));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(encoded);
        System.out.println(Arrays.toString(decoded));
    }

    private static void encode1() {

        Base64.Encoder encoder = Base64.getEncoder();
        String normalString = "username:password";
        String encodedString = encoder.encodeToString(
                normalString.getBytes(StandardCharsets.UTF_8) );

        System.out.println(encodedString);
    }
}
