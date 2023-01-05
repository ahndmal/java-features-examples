package com.anma.java.core.concur.execs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyExecutorsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void execs() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> {
            System.out.println("Hello!");
        }, 1, 10, TimeUnit.SECONDS);
    }
}