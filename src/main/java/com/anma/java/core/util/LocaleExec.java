package com.anma.java.core.util;

import java.util.Locale;

public class LocaleExec {
    public static void main(String[] args) {

        Locale eng = Locale.ENGLISH;
        Locale us = Locale.getDefault();

        System.out.println(us.getScript());
        System.out.println(us.getCountry());
        System.out.println(us.getVariant());
        System.out.println(us.getLanguage());
    }
}
