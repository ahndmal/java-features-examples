package com.anma.java.core.time;

import java.time.*;

public class TimeMiscExe {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(LocalDate.now().toEpochDay());

        System.out.println(instant.toString());


    }
}
