package com.anma.java.core.time;

import java.time.Month;
import java.time.YearMonth;

public class YearMonthExe {

    public static void main(String[] args) {

        YearMonth yearMonth1 = YearMonth.now();
        YearMonth yearMonth2 = YearMonth.of(2020, 8);
        YearMonth yearMonth3 = YearMonth.parse("2020-08");

        Month month = yearMonth3.getMonth();

        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth2.lengthOfYear());
    }
}
