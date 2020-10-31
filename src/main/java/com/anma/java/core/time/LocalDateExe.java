package com.anma.java.core.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class LocalDateExe {
    public static void main(String[] args) {

        String dateFromParams = null;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate resultDateFromParams;

        if (dateFromParams != null) {
            resultDateFromParams = LocalDate.parse(dateFromParams, dateTimeFormatter);
        } else {
            resultDateFromParams = LocalDate.now().minusDays(7);
        }

        System.out.println(resultDateFromParams);

    }

    private static void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate1 = LocalDate.of(2020, 7,8);
        LocalDate localDate2 = LocalDate.from(LocalDate.now());
        LocalDate localDate3 = LocalDate.parse("2019-10-23");
        LocalDate localDate4 = LocalDate.parse("23/10/2019", dateTimeFormatter);
        LocalDate localDate5 = localDate1.plusMonths(2).plusDays(3);
        LocalDate localDate6 = localDate1.withYear(2021).withMonth(7);

        System.out.println(localDate3.getDayOfWeek().toString());

        String formattedDate = localDate1.format(dateTimeFormatter);

        System.out.println(formattedDate);
        System.out.println(localDate5);
        System.out.println(localDate6);
    }
}
