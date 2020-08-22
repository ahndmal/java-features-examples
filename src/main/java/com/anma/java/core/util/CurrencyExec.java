package com.anma.java.core.util;


import java.util.Currency;
import java.util.Set;

public class CurrencyExec {

    public static void main(String[] args) {

        Set<Currency> currencies = Currency.getAvailableCurrencies();
//        currencies.forEach(System.out::println);

        Currency uah = Currency.getInstance("UAH");
        System.out.println(uah.getDisplayName());;
        System.out.println(uah.getDefaultFractionDigits());
        System.out.println(uah.getCurrencyCode());
        System.out.println(uah.getNumericCode());
        System.out.println(uah.getSymbol());
    }
}
