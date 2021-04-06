package com.anma.java.core.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExe {

    public static void main(String[] args) {

        IntStream.of(1,2,3,4).filter(it -> it > 2);
        int res3 = IntStream.generate(() -> (int) Math.random() * 10).takeWhile(n -> n != 3).sum();
        Stream.builder().add("Hello").add("there").build().findFirst();
        Arrays.stream(new String[] {"aaa", "bbb"}).map(s -> s.trim());
    }
}
