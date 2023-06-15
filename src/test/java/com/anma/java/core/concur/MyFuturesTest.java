package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void sub1() {

        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 100000; i++) {
                long a = 12234243142431432L;
                a = a  / 123 - 123134 + 123343;
                long b = a / 12345 + 1034324 - 123123 * 2 / 45 / 2 * 40 * 2 / 12 / 2 * 10;
                long c = a - b;
                System.out.println(c);
            }
        });
        System.out.println(completableFuture.isDone());
    }

    @Test
    void simpleSout() {
        var start = System.currentTimeMillis();
        var startMoment = LocalDateTime.now();
        for (int i = 0; i < 100000; i++) {
            long a = 12234243142431432L;
            a = a  / 123 - 123134 + 123343;
            long b = a / 12345 + 1034324 - 123123 * 2 / 45 / 2 * 40 * 2 / 12 / 2 * 10;
            long c = a - b;
            System.out.println(c);
        }
        var end = Duration.between(startMoment, LocalDateTime.now()).toMillis();
        System.out.println(end);
    }
}