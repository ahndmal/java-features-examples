package com.anma.java.core.time;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeExe {

    public static void main(String[] args) {

//        LocalTime localTime1 = LocalTime.from(LocalDateTime.parse("2019-10-23"));
        LocalTime localTime2 = LocalTime.of(21, 21, 45, 34567);
        LocalTime localTime3 = LocalTime.parse("10:18");
        LocalTime localTime4 = localTime2.withHour(22).withMinute(21);

        System.out.println(localTime2);
        System.out.println(localTime3);
        System.out.println(localTime4);
    }
}
