package com.anma.java.exam.inter;

public class ExamInterface {
    public static void main(String[] args) {


    }
}

interface A {
    static final int X = 10;
    abstract void meth();
}

interface B {
    static final int X = 20;
    abstract void meth();
}

interface C extends A {

}

abstract class D implements A, B {
    public void meth() {        // should be public
        int fromA = A.X;
        int fromB = B.X;
    }
}