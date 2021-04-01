package com.anma.java.exam.inter;

interface Black {
    default void getColor() {
        System.out.println("Black");
    }
}

interface Red {

    default void getColor() {
        System.out.println("Red");
    }
}

interface Gold {
    default void getColor() {
        System.out.println("Gold");
    }
}

public class Colors implements Black, Red, Gold {

    public void getColor() {
        Red.super.getColor();
    }

    public static void main(String[] args) {

        Colors colors = new Colors();
        colors.getColor();
    }
}

interface RateA {           // "abstract" and "default"  cannot be "private"
    static final double rate = 1.3;
    default void increase() {
       //rate = rate + 4;
        System.out.println(rate + 1);
    }
}

abstract class AbsCl {
    double rate = 4.3;
//    abstract void increaseTax() {     // abstract methods cannot have body
//        rate = rate + 2;
//    }
}
