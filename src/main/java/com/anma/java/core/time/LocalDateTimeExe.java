package com.anma.java.core.time;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.Random;

public class LocalDateTimeExe {

    public static void main(String[] args) {

        Random random = new Random();

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 10, 21, 10, 45, 56);
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDateTime localDateTime5 = LocalDateTime.of(2017, Month.AUGUST, 23, 12, 10);
        LocalDateTime localDateTime6 = localDateTime1.plusMonths(1).plusDays(3);

        LocalDateTime epochal = LocalDateTime.ofInstant(Instant.ofEpochSecond(1188075000L), ZoneId.of("Pacific/Apia"));
        System.out.println(epochal);
        System.out.println("====");

        for (int i = 0; i < 20; i++) {
            LocalDateTime randomDate = LocalDateTime.of(2021,
                    random.nextInt(12),
                    random.nextInt(26),
                    random.nextInt(12),
                    random.nextInt(59),
                    random.nextInt(59));
            System.out.println(randomDate);
        }
    }
}
