package com.anma.java.core.concur.mutn;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.UniEmitter;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MutnOne {
    public static void main(String[] args) {
        Uni<Integer> uni = Uni.createFrom().item(1);
        Cancellable cancellable = uni
                .subscribe().with(
                        item -> System.out.println(item),
                        failure -> System.out.println("Failed with " + failure));

        AtomicInteger counter = new AtomicInteger();
        Uni<Integer> uni2 = Uni.createFrom().item(() -> counter.getAndIncrement());

        Uni<Void> uniVoid = Uni.createFrom().nullItem();


        Uni.createFrom().item("Item 1").onItem()
                .delayIt().by(Duration.ofSeconds(1))
                .subscribe().with(it -> System.out.println(it));

        Multi.createFrom()
                .iterable(List.of(1, 2, 3, 4, 5))
                .onItem()
                .invoke((i) -> System.out.println(i))
                .subscribe().asIterable();

        CompletionStage stage = CompletableFuture.runAsync(() -> {
            System.out.println("Inside completion stage");
        });
        Uni<String> uniFromStage = Uni.createFrom().completionStage(stage);
        uniFromStage.onItem().transform(i -> i + " added ").subscribe().with(el -> {});

    }

    public void emitOne() {
        Supplier<String> supplier = () -> " in supplier ";
        BiConsumer<String, UniEmitter<? super String>> consumer = (con, em) -> { em.fail(new RuntimeException("exception")); ; };
        Uni.createFrom().emitter(supplier, consumer).onItem();

        Uni<String> uni = Uni.createFrom().emitter(em -> {
            var result = "result!";
            // When the result is available, emit it
            em.complete(result);
        });

    }
}
