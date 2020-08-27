package com.anma.java.core.util;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Scanner;

class MyList extends AbstractList<String> {

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

class MyCollection extends AbstractCollection<String> {

    @Override
    public Iterator iterator() {

        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

public class MyCollectionExe {

    public static void main(String[] args) {

        MyCollection myCollection1 = new MyCollection();
        myCollection1.add("Hello");
        myCollection1.add("there");

//        myCollection1.forEach(System.out::println);

        MyList list1 = new MyList();
        list1.add("Hello");
        list1.add("there");
        list1.forEach(System.out::println);

    }
}
