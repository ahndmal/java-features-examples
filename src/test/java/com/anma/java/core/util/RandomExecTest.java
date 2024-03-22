package com.anma.java.core.util;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomExecTest {

    @Test
    void randomString() {

        System.out.println(RandomExec.randomStringWithExclamations(12));

    }
}