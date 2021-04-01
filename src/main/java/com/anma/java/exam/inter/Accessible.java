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
        double a = new RestrictedWith().verifyWithdrawal(1.2, 3);
        System.out.println(a);
    }
}
