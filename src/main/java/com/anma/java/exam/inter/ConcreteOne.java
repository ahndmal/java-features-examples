package com.anma.java.exam.inter;

interface InterfaceOne {
    int field = 99;
    default void method() {
        System.out.println(field);
    }
}

interface InterfaceTwo {
    int field = 1983;
    private void method() {
        System.out.println(field);
    }
}

public class ConcreteOne implements InterfaceOne, InterfaceTwo {
    public static void main(String[] args) {
        ConcreteOne concreteOne = new ConcreteOne();
        concreteOne.method();
    }
}
