package com.anma.java.core.time;

import java.time.Clock;

public class ClockExe {
    public static void main(String[] args) {

        Clock clock = Clock.systemDefaultZone();

        System.out.println(clock.getZone());
        System.out.println(clock.millis());
    }
}
