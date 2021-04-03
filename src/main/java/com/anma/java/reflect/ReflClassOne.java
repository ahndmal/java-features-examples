package com.anma.java.reflect;

public class ReflClassOne {

    static int seq = 4;

    private int id;
    private String name;

    public ReflClassOne() {}

    public ReflClassOne(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflClassOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
