package com.anma.java.core.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleExec {

    public static void main(String[] args) {
        resources();
    }

    private static void resources() {

        Locale locale = new Locale("en", "GB");
        Locale localeRu = new Locale("ru");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        String hello = bundle.getString("hello");
        System.out.println(hello);
    }

    private static void localeMisc1() {
        Locale eng = Locale.ENGLISH;
        Locale aDefault = Locale.getDefault();
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
