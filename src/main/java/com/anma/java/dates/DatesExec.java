package com.anma.java.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesExec {

    public static void main(String[] args) throws ParseException {

    }

//     LocalDateTime
    private static void localDateTime() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }


//     Local Time
    private static void localTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }


//  YearMonth
    private static void yearMonth() {
        YearMonth yearMonth = YearMonth.now();
        YearMonth yearMonth2 = YearMonth.of(2020, 1);

        System.out.println(yearMonth);
        System.out.println(yearMonth2);
    }

// LocalDate
    private static void localDate() {
        LocalDate localDate = LocalDate.of(2020, 5, 26);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate1 = LocalDate.parse("26/05/2020", dateTimeFormatter);

        System.out.println("LocalDate from Formatter === " + localDate1);
        System.out.println("Local Date from digits === " + localDate);
    }

//   Year
    private static void years() {
        Year year = Year.parse("2018");
        Year year2 = Year.now();
        Year year3 = Year.of(2019);

        System.out.println(year);
        System.out.println(year2);
        System.out.println(year3.atDay(23));
    }

//   Calendars
    private static void calendars() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.getFirstDayOfWeek();

        TimeZone timeZone = calendar.getTimeZone();
        calendar.getWeekYear();
        System.out.println(calendar.get(Calendar.WEDNESDAY));


        Calendar.Builder builder = new Calendar.Builder();
        Calendar calendar1 = builder.setFields(Calendar.YEAR, 2020,
                Calendar.MONTH, Calendar.AUGUST,
                Calendar.DAY_OF_MONTH, 23).build();
    }


//    Month Days
    private static void monthDays() {
        MonthDay monthDay = MonthDay.now();
        DayOfWeek dayOfWeek = DayOfWeek.of(3);
        Month month = Month.of(5);

        System.out.println(monthDay);
        System.out.println(dayOfWeek);
        System.out.println(month);
    }

//  Date
    private static void dates() {
        
        Date fromInstant = Date.from(Instant.now());
        Date date = new Date(1234556);
        Date date2 = new Date(2020, 5, 26);

        System.out.println(Instant.now());
        System.out.println(fromInstant);
        System.out.println(date);
        System.out.println(date2);

//        DateFormat dateFormat = DateFormat.getInstance();
//        Date dateFromFOrmat = dateFormat.parse("26-05-2020");
//        System.out.println(dateFromFOrmat);
    }
}
