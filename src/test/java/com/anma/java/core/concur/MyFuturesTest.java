package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

class MyFuturesTest {
    @Test
    void testFuture() {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1L, TimeUnit.HOURS, new ArrayBlockingQueue<>(1));
//        ExecutorCompletionService service = new ExecutorCompletionService<>(threadPoolExecutor);
//        service.submit(() -> {
//            System.out.println();
//            return "";
//        }), "res";
    }

    @Test
    void pubs2() {
        Flow.Publisher publisher = new Flow.Publisher() {
            @Override
            public void subscribe(Flow.Subscriber subscriber) {
                subscriber.onNext("item 1");
                subscriber.onSubscribe(new Flow.Subscription() {
                    @Override
                    public void request(long n) {
                        System.out.println("> request " + n);
                    }

                    @Override
                    public void cancel() {
                        System.out.println("Cancelling");
                    }
                });
                subscribe(subscriber);
            }
        };
    }

    @Test
    void completableFutureOned() {
        Future future = new FutureTask<>(() -> {
            calc();
        }, "res");
//        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
//            calc();
//        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
    }

    @Test
    void simpleSout() {
        var startMoment = LocalDateTime.now();
        calc();
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(end);
    }

    @Test
    void randomm() {
        for (int i = 0; i < 10; i++) {
            var rand = new Random().nextInt(1_000_000, 1_000_000_000);
            System.out.println(rand);
        }
    }

    private static void calc() {
        for (int i = 0; i < 100000; i++) {
            long a = 82234243142431432L;
            var rand = new Random().nextInt(1000000, 1000000000);
            long[] arr = {rand * 3L, rand * 2L, rand, rand, rand, rand, rand, rand};
            for (int j = 0; j < arr.length; j++) {
                a = arr[j] + a / 21333 - (123134 + 980980665) + (123123123 + 31213123)
                        / 3 - 213213213 / 3 * 20 / 4 / 2 * 2 / 20 * 20;
                long b = a / 12345 + 1034324 - 123123 * 2 / 45 / 2 * 40 * 2 / 12 / 2 * 10;
                long c = a - b;
                System.out.println(c);
            }
        }
    }
}