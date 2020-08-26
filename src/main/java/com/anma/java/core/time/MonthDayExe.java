package com.anma.java.core.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class MonthDayExe {

    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd");

        MonthDay monthDay1 = MonthDay.now();
        MonthDay monthDay2 = MonthDay.from(LocalDate.parse("2019-10-23"));
        MonthDay monthDay3 = MonthDay.of(9, 18);
        MonthDay monthDay4 = MonthDay.of(Month.OCTOBER, 18);
        MonthDay monthDay5 = MonthDay.parse("--07-31");
        MonthDay monthDay6 = MonthDay.parse("07-31", dateTimeFormatter);

        System.out.println(monthDay1);
        System.out.println(monthDay2);
        System.out.println(monthDay5);
        System.out.println(monthDay6);

        LocalDate localDate = monthDay1.atYear(2020);
    }
}
