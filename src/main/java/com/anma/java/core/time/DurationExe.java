package com.anma.java.core.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExe {
    public static void main(String[] args) {

        Duration hoursDuration = Duration.ofHours(200);
        Duration daysDuration = Duration.ofDays(2);
//        System.out.println(hoursDuration.toSeconds());
//        System.out.println(daysDuration.toHours());

        Duration betweenn2hours = Duration.between(LocalTime.now(), LocalTime.now().plusHours(2));
        System.out.println(betweenn2hours.toMinutes());


        Duration threeDays = Duration.of(3, ChronoUnit.DAYS);
//        System.out.println(threeDays.toHours());


    }
}
