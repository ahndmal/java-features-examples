package com.anma.java.core.time;

import java.time.*;

public class LocalDateTimeExe {

    public static void main(String[] args) {

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 10, 21, 10, 45, 56);
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDateTime localDateTime5 = LocalDateTime.of(2017, Month.AUGUST, 23, 12, 10);
        LocalDateTime localDateTime6 = localDateTime1.plusMonths(1).plusDays(3);

    }
}
