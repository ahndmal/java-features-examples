package com.anma.java.core.text;

import java.text.DecimalFormat;

public class DecimalFormatExe {

    public static void main(String[] args) {

        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();

        DecimalFormat decimalFormat1 = new DecimalFormat("#0.00");

        String formatted = decimalFormat1.format(45.34567);
        double formattedDouble = Double.parseDouble(decimalFormat1.format(45.34567));

        System.out.println(formatted);
    }
}
