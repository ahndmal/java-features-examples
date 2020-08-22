package com.anma.java.core.lists;

import java.util.*;

public class ListsExec {
    public static void main(String[] args) {

        List<String> strList1 = Arrays.asList("aaa", "bbb");
//        strList1.forEach(System.out::println);

        ArrayDeque<String> deque = new ArrayDeque<String>();
        deque.add("two");
        deque.add("three");
        deque.addFirst("one");
//        System.out.println(deque.getLast());
//        System.out.println(deque.pop());
//        System.out.println(deque.element());

        Collection<Integer> collection = new HashSet<>();
        collection.add(102);
        collection.add(103);
//        System.out.println(collection.size());

        List empty1 = Collections.list(Collections.enumeration(Arrays.asList(0.5, 0.6)));
        empty1.add(0.7);
        System.out.println(empty1.get(0));



    }
}
