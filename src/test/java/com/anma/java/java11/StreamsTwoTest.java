package com.anma.java.java11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTwoTest {

    @Test
    void testStreamsTwo() {
        List<Integer> arr = new ArrayList<>();
        int[] values = {1,2,3,4,5,6,7};
        Arrays.stream(values).filter(x -> x % 2 == 0).forEach(arr::add);
    }

    @Test
    void main() {
    }

    @Test
    public void testTwo() {
        int a = 57;
        char c = 'C';
        String str1 = "this is string one";
        System.out.println("test");
    }
}