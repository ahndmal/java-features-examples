package com.anma.java.core.time;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class OffsetDateTimeExe {

    public static void main(String[] args) {

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);

        OffsetTime offsetTime = OffsetTime.of(LocalTime.now(), ZoneOffset.UTC);
        System.out.println(offsetTime);
    }
}
