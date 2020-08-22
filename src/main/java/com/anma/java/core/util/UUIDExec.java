package com.anma.java.core.util;

import java.util.UUID;

public class UUIDExec {

    public static void main(String[] args) {

        UUID uuid = UUID.randomUUID();
        UUID uuid1 = UUID.fromString("f0242d83-ff62-401b-ab3e-713931df6dfb");

        System.out.println(uuid);
        System.out.println(uuid.hashCode());
        System.out.println(uuid.variant());
        System.out.println(uuid.version());
        System.out.println(uuid.timestamp());
    }
}
