package com.anma.java.exam.conditions;

public class ConditionOne {

    public static void main(String[] args) {

        int a = 4;
        int b = 3;

        if (a % 2 == 0 && b % 2 == 0) {
            System.out.println("True");
        }

        if (b % 2 == 0 & a % 2 == 0) {
            System.out.println("False");
        }

        switch (a) {
            case 2:
                a = 4;
                break;
            case 3:
                a = 8;
                break;
            default:
                a = 5;
        }


    }
}
