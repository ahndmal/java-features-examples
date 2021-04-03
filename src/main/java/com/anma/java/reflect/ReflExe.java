package com.anma.java.reflect;

public class ReflExe {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {

        Class<?> classOne = ReflClassOne.class.getClassLoader().loadClass("ReflClassOne");
        System.out.println(classOne.toString());


    }
}
