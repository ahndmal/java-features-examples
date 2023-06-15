package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

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
    void sub1() {
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
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 100000; i++) {
                long a = 12234243142431432L;
                long b = a / 12345 + 1034324 - 123123 * 2;
                long c = a - b;
                System.out.println(c);
            }
        });
        System.out.println(completableFuture.isDone());
    }
}