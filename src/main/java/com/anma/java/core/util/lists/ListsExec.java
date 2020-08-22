package com.anma.java.core.util.lists;

import java.util.*;

public class ListsExec {

    public static void main(String[] args) {

        List empty1 = Collections.list(Collections.enumeration(Arrays.asList(0.5, 0.6)));
        empty1.add(0.7);

        System.out.println(empty1.get(0));

        List<Double> list2 = Collections.checkedList(empty1, Double.class);

        List<Integer> intList1 = new ArrayList<>() ;
        intList1.add(1);
        intList1.add(1);
        intList1.add(2);
        int freq = Collections.frequency(intList1, 1);
        System.out.println(freq);

    }

    private static void misc() {

        List<String> strList1 = Arrays.asList("aaa", "bbb");
        strList1.forEach(System.out::println);

        Collection<Integer> collection = new HashSet<>();
        collection.add(102);
        collection.add(103);
        System.out.println(collection.size());
    }

    private static void deque() {

        ArrayDeque<String> deque = new ArrayDeque<String>();
        deque.add("two");
        deque.add("three");
        deque.addFirst("one");

        System.out.println(deque.getLast());
        System.out.println(deque.pop());
        System.out.println(deque.element());
    }
}
