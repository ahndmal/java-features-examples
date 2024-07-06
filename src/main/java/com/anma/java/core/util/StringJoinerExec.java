package com.anma.java.core.util;

import java.util.StringJoiner;

public class StringJoinerExec {

    public void joiner() {

        StringJoiner joiner = new StringJoiner(":");

        joiner.add("One").add("Two").add("Three");

        System.out.println(joiner.toString());
    }
}
