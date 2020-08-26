package com.anma.java.core.time;

import java.time.Duration;

public class DurationExe {
    public static void main(String[] args) {

        Duration hoursDuration = Duration.ofHours(200);
        Duration daysDuration = Duration.ofDays(2);

        System.out.println(hoursDuration.toSeconds());
        System.out.println(daysDuration.toHours());
    }
}
