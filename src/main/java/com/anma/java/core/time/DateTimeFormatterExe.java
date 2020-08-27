package com.anma.java.core.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExe {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter3 = DateTimeFormatter.ISO_TIME;

        ZoneId zoneId = formatter2.getZone();
        System.out.println(zoneId);

        LocalDate localDate = (LocalDate) formatter2.parse("23/11/2019");
        System.out.println(localDate);
    }
}
