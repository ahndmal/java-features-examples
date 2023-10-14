package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class CountedCompleterTests {
    @Test
    void executors() {
        Callable<Object> callable = Executors.callable(() -> {
            System.out.println("> Calling callable");
        });
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testOne() {
//        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(
//                () -> {};
//        );
        CountedCompleter countedCompleter = new CountedCompleter() {
            @Override
            public void compute() {

            }
        };

        ForkJoinTask forkJoinTask = new ForkJoinTask() {
            @Override
            public Object getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }
        };
    }
}
