package com.anma.java.core.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedExe {
    public static void main(String[] args) {

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId LA = ZoneId.of("America/Los_Angeles");

        LocalDateTime someTime = LocalDateTime.now();
        ZonedDateTime londonTime = ZonedDateTime.of(someTime, london);
        ZonedDateTime laTime = londonTime.withZoneSameInstant(LA);
        System.out.println(londonTime);
        System.out.println(laTime);

    }
}
