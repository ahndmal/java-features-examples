package com.anma.java.core.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Cat {
     String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

public class ClassExe {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.setName("Name");

        Field[] fields = cat.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Field == " + fields[i].toString());
        }
        Method[] methods = cat.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Method == " + methods[i].getName());
        }

    }
}
