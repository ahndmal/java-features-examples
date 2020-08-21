package com.anma.java.core.lists;

import java.util.Arrays;
import java.util.List;

public class ListsExec {
    public static void main(String[] args) {

        List<String> strList1 = Arrays.asList("aaa", "bbb");
        strList1.forEach(System.out::println);
    }
}
