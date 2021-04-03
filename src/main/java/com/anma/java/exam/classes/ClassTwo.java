package com.anma.java.exam.classes;

enum Age {
    ONE, TWO
}

public class ClassTwo {

    Age someAge = Age.ONE;

    public String test(String b, int a) {
        return "";
    }

    public String test(String a) {
        return  "aa";
    }

    public Age getSomeAge() {
        return someAge;
    }
}
