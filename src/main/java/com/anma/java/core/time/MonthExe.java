package com.anma.java.core.time;

import java.time.Month;

public class MonthExe {

    public static void main(String[] args) {

        Month jan = Month.JANUARY;
        Month feb = Month.of(2);
        Month march = Month.valueOf("MARCH");

        int febValue = feb.getValue();
        int length = feb.length(true);
        int minLength = feb.minLength();
        int maxLength = feb.maxLength();

        System.out.println(maxLength);



    }
}
