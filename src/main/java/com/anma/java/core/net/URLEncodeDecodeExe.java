package com.anma.java.core.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLEncodeDecodeExe {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String encoded = URLEncoder.encode("https://www.codota.com/code/java/classes/java.net.URLDecoder", StandardCharsets.UTF_8);
        System.out.println(encoded);

        String decoded = URLDecoder.decode("https://www.codota.com/code/java/classes/java.net.URLDecoder", StandardCharsets.UTF_8);
        System.out.println(decoded);

    }
}
