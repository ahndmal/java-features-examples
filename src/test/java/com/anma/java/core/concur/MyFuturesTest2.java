package com.anma.java.core.concur;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class MyFuturesTest2 {

    @Test
    void futuresMisc() {
        Future future;
        CompletableFuture completableFuture;
        ScheduledFuture scheduledFuture;
        RunnableFuture runnableFuture;
        RunnableScheduledFuture runnableScheduledFuture;

        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("> inside future Task runnable");
            return "runnable data";
        });
        futureTask.run();
        
        CompletableFuture completableFuture1 = new CompletableFuture();
        completableFuture1.thenAccept(System.out::println);
        CompletionStage completionStage;
        
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(">> completableFuture2 :: supply async");
            return "Completed";
        });
        try {
            String result2 = completableFuture2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void futuresOwn() {
        Future<String> future = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });

        Future.State state = future.state();
        System.out.println(state);

        try {
            String res = future.get();
            System.out.println(res);
            if (future.isDone()) {
                System.out.println(future.resultNow());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
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
        try {
            publisher.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}