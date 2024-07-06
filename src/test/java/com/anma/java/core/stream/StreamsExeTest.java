package com.anma.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StreamsExeTest {

    public static int[] pipeFix(int[] numbers) {

        int a = new Integer(10);

        return IntStream
                .rangeClosed(numbers[0], numbers[numbers.length - 1])
                .toArray();

    }

    @Test
    void mainTest() {
        var integers = IntStream.range(1, 10).boxed().toArray();

        System.out.println(Arrays.toString(pipeFix(new int[] {1,2,3,5,6,8,9})));
    }
}