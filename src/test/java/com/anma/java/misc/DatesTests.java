package com.anma.java.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatesTests {

    @Test
    void datesTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
        LocalDate date1 = LocalDate.from(formatter.parse("15/JUL/21"));
//        LocalDate date2 = LocalDate.from(formatter.parse("15/jul/21"));
        System.out.println(date1);
//        System.out.println(date2);
    }

    @Test
    void datesTestParse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse("15/JUL/21", formatter);
        System.out.println(date1);
    }


  /*
    @Test
    void datesTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
        LocalDate date1 = LocalDate.from(formatter.parse("15/JUL/21"));
//        LocalDate date2 = LocalDate.from(formatter.parse("15/jul/21"));
        System.out.println(date1);
//        System.out.println(date2);
    }

    @Test
    void datesTestParse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse("15/JUL/21", formatter);
        System.out.println(date1);
    }
   */

    @Test
    void dates3() {
        LocalDate date = LocalDate.of(2021, 6, 15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
        var dateString = date.format(formatter);
        System.out.println(dateString);
    }

    @Test
    void formatDatesUpper() {
        String date = "15/JUL/21";
        String month = date.split("/")[1];
        if (Character.isUpperCase(month.charAt(1))) {
            date = date.replace(date.charAt(4), Character.toLowerCase(date.charAt(4))).replace(date.charAt(5), Character.toLowerCase(date.charAt(5)));
        }
        Assertions.assertEquals(date, "15/Jul/21");

    }
}
