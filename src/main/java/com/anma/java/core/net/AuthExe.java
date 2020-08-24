package com.anma.java.core.net;

import java.net.*;

public class AuthExe {

    public static void main(String[] args) throws MalformedURLException, UnknownHostException {

        Authenticator authenticator = Authenticator.getDefault();
        PasswordAuthentication authentication =
                authenticator.requestPasswordAuthenticationInstance("",
                        InetAddress.getByName("anma-workouts.herokuapp.com"),
                        80,
                        "https",
                        "",
                        "",
                        new URL("https://anma-workouts.herokuapp.com/"),
                        Authenticator.RequestorType.SERVER);
        System.out.println(authentication.getUserName());;
    }
}
