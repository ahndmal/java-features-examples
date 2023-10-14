package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.anma.java.core.srv.CalculationsService.calc;

public class CompFutuMiscTest {
    @Test
    void asyncCalcTest() {
        var startMoment = LocalDateTime.now();

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(">> completableFuture2 :: supply async");
            calc(100_000);
            return "Completed";
        });
        try {
            String result2 = completableFuture2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(" >>> " + end);
    }

    @Test
    void simpleCalcTest() {
        var startMoment = LocalDateTime.now();
        calc(100_000);
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(" >>> " + end);
    }




}
