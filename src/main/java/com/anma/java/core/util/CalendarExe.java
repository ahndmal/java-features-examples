package com.anma.java.core.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarExe {

    public static void main(String[] args) {

        Calendar calendar1 = Calendar.getInstance();

        Date date = calendar1.getTime();
        System.out.println(date);                                   // date

        TimeZone timeZone = calendar1.getTimeZone();
        System.out.println(timeZone.getDisplayName());

        calendar1.set(2020, Calendar.SEPTEMBER,28);
        calendar1.add(Calendar.DATE, 1);                    // + 1 day
        System.out.println(calendar1.getTime());

        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar1.get(Calendar.HOUR) + ":" + calendar1.get(Calendar.MINUTE) + ":" + calendar1.get(Calendar.SECOND));
        System.out.println(calendar1.get(0));
        System.out.println(calendar1.get(1));
        System.out.println(calendar1.getCalendarType());
        System.out.println(calendar1.getFirstDayOfWeek());

        getOldWeekDays().forEach(System.out::println);
    }

    public static List<String> getOldWeekDays() {

        final Calendar calendar = Calendar.getInstance();
        String[] months = new String[8];
        for (int i = 0; i < 8; i++) {
            months[i] = new SimpleDateFormat("MM.dd").format(new Date(calendar.getTimeInMillis()));
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return Arrays.asList(months);
    }
}
