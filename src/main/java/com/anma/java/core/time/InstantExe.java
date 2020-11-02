package com.anma.java.core.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class InstantExe {

    public static void main(String[] args) {

        Instant instant1 = Instant.from(LocalDateTime.of(2020,11,2,11,25));
        Instant instant2 = instant1.plus(2,ChronoUnit.DAYS);

        System.out.println(instant2);
    }
}
