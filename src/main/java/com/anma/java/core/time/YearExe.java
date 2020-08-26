package com.anma.java.core.time;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class YearExe {

    public static void main(String[] args) {

        Year year1 = Year.from(LocalDate.of(2020, 3, 4));
        Year year2 = Year.of(2019);
        Year year3 = Year.now();

        YearMonth yearMonth = year1.atMonth(10);
        LocalDate localDate1 = year1.atDay(10);
        LocalDate localDate2 = year2.atMonthDay(MonthDay.of(9, 29));

        System.out.println(year1);
        System.out.println(year3.length());
    }
}
