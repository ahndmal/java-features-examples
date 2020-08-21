package com.anma.java.core.arrays;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {

        int[] arr1 = new int[4];
        int[] arr2 = {1, 2, 3, 4, 5};
        String[] arr3 = new String[] {"Hello", "Petro"};

        Arrays.fill(arr1, 4);
//        System.out.println(Arrays.toString(arr1));

        int result = Arrays.binarySearch(arr1, 4);
        System.out.println(result);


    }
}
