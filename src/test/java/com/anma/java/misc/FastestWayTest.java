package com.anma.java.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class FastestWayTest {

    @Test
    public void testGreetWithEquals() {

        assertEquals(FastestWay.shortestWay(100, 100, 50, 50), "Any City");
        assertEquals(FastestWay.shortestWay(90, 80, 50, 40), "City A: 1 hour(s)");
        assertEquals(FastestWay.shortestWay(320, 400, 50, 80), "City B: 5 hour(s)");
        assertEquals(FastestWay.shortestWay(700, 700, 100, 110), "City B: 6 hour(s)");
        assertEquals(FastestWay.shortestWay(70, 90, 60, 60), "Any City");

    }

    @Test
    public void randomTests() {

        int distA = getRandom(100, 1000);
        int distB = getRandom(100, 1000);
        int carSpeed = getRandom(20, 90);
        int trainSpeed = getRandom(20, 90);

        int timeToA = distA / carSpeed;
        int timeToB = distB / trainSpeed;

        if (timeToA == timeToB) {
            assertEquals("Any City", FastestWay.shortestWay(distA, distB, carSpeed, trainSpeed));
        } else if(timeToA < timeToB) {
            assertEquals("City A: " + timeToA + " hour(s)", FastestWay.shortestWay(distA, distB, carSpeed, trainSpeed));
        } else {
            assertEquals("City B: " + timeToB + " hour(s)", FastestWay.shortestWay(distA, distB, carSpeed, trainSpeed));
        }
    }

    private int getRandom(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}