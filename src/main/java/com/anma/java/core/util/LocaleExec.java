package com.anma.java.core.util;

import java.util.Locale;

public class LocaleExec {

    public static void main(String[] args) {
        localeMisc1();
    }

    private static void localeMisc1() {
        Locale eng = Locale.ENGLISH;
        Locale us = Locale.getDefault();
//        Locale ua1 = Locale.forLanguageTag("uk_UA");
        Locale ua2 = new Locale("uk", "UA");

//        System.out.println(us.getScript());
//        System.out.println(us.getCountry());
//        System.out.println(us.getVariant());
//        System.out.println(us.getLanguage());
        System.out.println(ua2.getCountry());
        System.out.println(ua2.getDisplayCountry());
        System.out.println(ua2.getLanguage());
    }

    private static void locales() {

        Locale[] locales = Locale.getAvailableLocales();
        for (int i = 0; i < locales.length; i++) {
            System.out.println(locales[i]);
        }
    }
}
