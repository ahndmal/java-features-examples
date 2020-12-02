package com.anma.java.core.util.lists;

import java.util.*;

public class ListsExec {

    public static void main(String[] args) {

        System.out.println(findDuplicates(Arrays.asList("Page1", "Page2", "Page3", "Page2", "Page4", "Page3", "Page5")));

    }

    private static void list3() {
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

//    public static void findDuplicates(List<String> pageTitles) {
//
//        Set<String> uniqueTitles = new HashSet<>();
//        Set<String> duplicateTtiles = new HashSet<>();
//
//
//
//        for (String page : pageTitles) {
//            if (!uniqueTitles.add(page)) {
//                duplicateTtiles.add(page);
//                System.out.println(page);
//            }
//        }
//
//        duplicateTtiles.forEach(System.out::println);
//    }

    private static  <T> Set<T> findDuplicates(Collection<T> collection) {

        Set<T> duplicates = new LinkedHashSet<>();
        Set<T> uniques = new HashSet<>();

        for(T t : collection) {
            if(!uniques.add(t)) {
                duplicates.add(t);
            }
        }

        return duplicates;
    }
}
