package com.anma.java.exam.inter;

public interface Accessible {

    public default double verifyWithdrawal(double amount, int pin) {
        return amount + pin;
    }
}

class RestrictedWith implements Accessible {

    public double verifyWithdrawal(double amount, int pin) {
        return Accessible.super.verifyWithdrawal(amount, pin);
    }

    public static void main(String[] args) {

//        double a = new RestrictedWith().verifyWithdrawal(1.2, 3);
//        System.out.println(a);
//
//        char c = '\u0073';
//        System.out.println(Character.charCount(6));
//        System.out.println(c);
//
//        float e = 1.2f;

        System.out.println(Math.round(11 / 3));
    }
}
