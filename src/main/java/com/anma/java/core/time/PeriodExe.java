package com.anma.java.core.time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExe {

    public static void main(String[] args) {

        Period period1 = Period.between(LocalDate.now(), LocalDate.of(2020, 9, 18));
        Period period2 = Period.ofDays(100);


        System.out.println(period1.getDays());
        System.out.println(period2.toTotalMonths());
    }
}
