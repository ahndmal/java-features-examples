package com.anma.java.core.concur.strucconcur;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class StructuredCOncur<U, T> {
    public static void main(String[] args) {

    }

    void handleOrderStructured() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<Integer> inventory = scope.fork(this::updateInventory);
            Future<Integer> order = scope.fork(() -> updateOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            System.out.println("Inventory " + inventory.resultNow() + " updated for order " + order.resultNow());
        }
    }

    private <U extends Integer> U updateOrder() {
        return null;
    }

    private <U extends Integer> U updateInventory() {
            return null;
    }

    void handleOrder() throws ExecutionException, InterruptedException {
        try (var esvc = new ScheduledThreadPoolExecutor(8)) {
            Future<Integer> inventory = esvc.submit(() -> updateInventory());
            Future<Integer> order = esvc.submit(() -> updateOrder());

            int theInventory = inventory.get();   // Join updateInventory
            int theOrder = order.get();           // Join updateOrder

            System.out.println("Inventory " + theInventory + " updated for order " + theOrder);
        }
    }
}
