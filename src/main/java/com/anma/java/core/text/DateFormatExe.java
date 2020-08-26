package com.anma.java.core.text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatExe {

    public static void main(String[] args) {

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MONTH_FIELD, Locale.ENGLISH);
        String formattedDate = dateFormat.format(new Date());
        System.out.println(formattedDate);
    }
}
