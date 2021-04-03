package com.anma.java.core.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigDecimalExe {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(new BigInteger("123.4567"));
        BigDecimal bigDecimal2 = new BigDecimal("12.784");
        bigDecimal2.add(bigDecimal).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal2);
    }
}
