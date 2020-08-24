package com.anma.java.core.net;

import java.net.*;

public class HttpCookieExe {

    public static void main(String[] args)  {

        HttpCookie httpCookie = new HttpCookie("name", "Andrii");

        httpCookie.setComment("Some comment");
        httpCookie.setMaxAge(1234567);
        httpCookie.setVersion(1);


    }
}
