package com.anma.java.misc;

public class FastestWay {

    int distanceToA;
    int distanceToB;
    int carSpeed;
    int trainSpeed;

    public static String shortestWay(int distanceToA, int distanceToB, int carSpeed, int trainSpeed) {

        int timeToA = distanceToA / carSpeed;
        int timeToB = distanceToB / trainSpeed;

        if (timeToA == timeToB) return "Any City";

        return timeToA < timeToB ? "City A: " + timeToA + " hour(s)" : "City B: " + timeToB + " hour(s)";

    }

}
