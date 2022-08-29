package com.anma.java.core.math;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DecimalsTest {

    @Test
    void testDecimals() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        try {

            double result = Double.parseDouble(decimalFormat.format(3.4563347f));
            System.out.println(result);
            System.out.printf("%.2f%n", 3.45678);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}