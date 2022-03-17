package com.anma.java.core.util.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Streams2 {
    public static void main(String[] args) {

        int[] intArr = {1,2,3,4,5,6,7};

        int sum = Arrays.stream(intArr).filter(n -> n % 2 == 0)
//                .collect(Collectors.toList().supplier(), Collectors.toList().accumulator(), Collectors.toList().combiner())
                .sum();

        System.out.println(sum);
    }
}
