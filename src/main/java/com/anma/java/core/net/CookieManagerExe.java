package com.anma.java.core.net;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class CookieManagerExe {

    public static void main(String[] args) throws URISyntaxException, IOException {

        CookieManager cookieManager = new CookieManager();

        Map<String, List<String>> requestHeaders = new HashMap<>();

        requestHeaders.put("TEST", Arrays.asList("TEST1", "TEST2"));

        System.out.println(cookieManager.get(new URI("https://docs.oracle.com/javase/8/docs/api/index.html"), requestHeaders));;
    }
}
