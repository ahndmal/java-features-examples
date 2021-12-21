package com.anma.java.core.math;

public class MathMIsc {

    public static void main(String[] args) {

        System.out.println(getCycleValue(2));
        double x = (2 + (2 / 4)) + (2 / 9) + (2 / 16) + (2 / 25) + (2 / 36) + (2 / 49);
        System.out.println(x);

    }

    public static double getCycleValue(double x) {

        double s = 0;

//        for (int i = 1; i <= 10; i++) {
//            s += x + (x / (Math.pow(i, 2)));
//        }

        for (int i = 1; i <= 10; i++) {
            x = x + (x / (Math.pow(i, 2)));
            s += x;
        }

        return s;

    }
}
