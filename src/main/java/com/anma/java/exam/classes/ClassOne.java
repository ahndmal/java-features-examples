package com.anma.java.exam.classes;

public abstract class ClassOne {

    public String getData() {
        return "Data";
    }

    public abstract String getAbsData();
}

class ClassOneOne extends ClassOne {

    @Override
    public String getAbsData() {
        return "Data from child class";
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public static void main(String[] args) {

    }
}
