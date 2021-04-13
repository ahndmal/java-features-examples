package com.anma.java.core.stream;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExe {

    public static void main(String[] args) {

        IntStream.of(1,2,3,4).filter(it -> it > 2);

        int res3 = IntStream.generate(() -> (int) Math.random() * 10).takeWhile(n -> n != 3).sum();

        Stream.builder().add("Hello").add("there").build().findFirst();

        Arrays.stream(new String[] {"aaa", "bbb"}).map(s -> s.trim());

        List<URI> uris = Stream.of("https://google.com", "http://example.com").map(URI::create).collect(Collectors.toList());

        Callable<String> client = () -> {
            return "client";
        };
        List<Callable<String>> clients = Stream.generate(() -> client).limit(5).collect(Collectors.toList());
    }

}
