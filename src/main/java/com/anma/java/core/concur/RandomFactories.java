package com.anma.java.core.concur;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomFactories {

    public static final String L_128_X_1024_MIX_RANDOM = "L128X1024MixRandom";

    void dynamicGenerators() {
        int NUM_PROCESSES = 100;

        RandomGeneratorFactory<RandomGenerator.SplittableGenerator> factory =
                RandomGeneratorFactory.of(L_128_X_1024_MIX_RANDOM);

        RandomGenerator.SplittableGenerator random = factory.create();

        IntStream processes = IntStream.rangeClosed(1, NUM_PROCESSES);

        processes.parallel().forEach(p -> {
            RandomGenerator r = random.split();
            System.out.println(p + ": " + r.nextLong());
        });
    }
    void generStreams() {
        int NUM_TASKS = 10;

        RandomGeneratorFactory<RandomGenerator.JumpableGenerator> factory =
                RandomGeneratorFactory.of("Xoshiro256PlusPlus");
        RandomGenerator.JumpableGenerator random = factory.create();

        class Task implements Runnable {
            private int p;
            private RandomGenerator r;

            public Task(RandomGenerator prng) {
                r = prng;
            }

            public void run() {
                System.out.println(r.nextLong());
            }
        }

        List<Thread> taskList = random
                .jumps()
                .limit(NUM_TASKS)
                .map(prng -> new Thread(new Task(prng)))
                .collect(Collectors.toList());
        taskList.stream().forEach(t -> t.start());
    }
}
