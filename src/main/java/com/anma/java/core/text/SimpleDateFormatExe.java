package com.anma.java.core.text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExe {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        System.out.println(simpleDateFormat.toPattern());
        System.out.println(simpleDateFormat.format(new Date()));

        simpleDateFormat.applyPattern("dd/MM/yyyy");
        
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
