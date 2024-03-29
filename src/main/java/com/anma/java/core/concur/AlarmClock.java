package com.anma.java.core.concur;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AlarmClock {

    private final ScheduledExecutorService scheduler;
    private final long initialDelay;
    private final long delayBetweenRuns;
    private final long shutdownAfter;

    AlarmClock(long initialDelay, long delayBetweenBeeps, long stopAfter) {
        this.initialDelay = initialDelay;
        this.delayBetweenRuns = delayBetweenBeeps;
        this.shutdownAfter = stopAfter;
        this.scheduler = Executors.newScheduledThreadPool(NUM_THREADS);
    }

    public static void main(String[] args) {
        AlarmClock alarmClock = new AlarmClock(3, 1, 20);
        alarmClock.activateAlarmThenStop();
    /*
    To start the alarm at a specific date in the future, the initial delay
    needs to be calculated relative to the current time, as in :
    Date futureDate = ...
    long startTime = futureDate.getTime() - System.currentTimeMillis();
    AlarmClock alarm = new AlarmClock(startTime, 1, 20);
    This works only if the system clock isn't reset.
    */
        System.out.println("Main ended.");
    }

    void activateAlarmThenStop() {
        Runnable soundAlarmTask = new SoundAlarmTask();
        ScheduledFuture<?> soundAlarmFuture = scheduler.scheduleWithFixedDelay(
                soundAlarmTask, initialDelay, delayBetweenRuns, TimeUnit.SECONDS
        );
        Runnable stopAlarm = new StopAlarmTask(soundAlarmFuture);
        scheduler.schedule(stopAlarm, shutdownAfter, TimeUnit.SECONDS);
    }

    private static final int NUM_THREADS = 1;
    private static final boolean DONT_INTERRUPT_IF_RUNNING = false;

    private static final class SoundAlarmTask implements Runnable {
        @Override
        public void run() {
            ++count;
            System.out.println("beep " + count);
        }

        private int count;
    }

    private final class StopAlarmTask implements Runnable {
        StopAlarmTask(ScheduledFuture<?> schedFuture) {
            this.schedFuture = schedFuture;
        }

        @Override
        public void run() {
            System.out.println("Stopping alarm.");
            schedFuture.cancel(DONT_INTERRUPT_IF_RUNNING);
      /*
       Note that this Task also performs cleanup, by asking the
       scheduler to shutdown gracefully.
      */
            scheduler.shutdown();
        }

        private ScheduledFuture<?> schedFuture;
    }

}
