package com.anma.java.core.time;

import java.time.Clock;

public class ClockExe {
    public static void main(String[] args) {

        Clock clock = Clock.systemDefaultZone();
        Clock clock2 = Clock.systemUTC();

        System.out.println(clock.getZone());
        System.out.println(clock2.millis());
    }
}
