package com.anma.java.core.proc;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProcessesTest {
    @Test
    void processes() {
        try {
            Processes.processes();
            Processes.setEnvTest();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}