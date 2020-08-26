package com.anma.java.core.time;

import java.time.DayOfWeek;

public class DayOfWeekExe {

    public static void main(String[] args) {

        DayOfWeek mo = DayOfWeek.MONDAY;
        DayOfWeek tu = DayOfWeek.of(2);
        DayOfWeek we = DayOfWeek.valueOf("WEDNESDAY");
        DayOfWeek th = we.plus(1);

        int mondayValue = mo.getValue();

        System.out.println(tu);
        System.out.println(we);
        System.out.println(th);
    }
}
