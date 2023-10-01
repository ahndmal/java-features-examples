package com.anma.java.core.concur;

import com.anma.java.core.srv.CalculationsService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FTasksTest {

    @Test
    void futureTasksTest() throws Exception {
        var startMoment = LocalDateTime.now();

        FutureTask<String> task1 = new FutureTask<>(() -> {
            CalculationsService.calc(100_000);
            return "success!";
        });
        task1.run();

        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(" >>> " + end);
    }

    @Test
    void executorAsync() throws Exception {
        for (int i = 0; i < 10000; i++) {
            Executors.callable(() -> System.out.println("AAA")).call();
        }
    }
}
