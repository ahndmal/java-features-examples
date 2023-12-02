package com.anma.java.core.proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProcTwo {
    static public void startProcessesTest() throws IOException, InterruptedException {
        List<ProcessBuilder> greps = new ArrayList<>();
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"java\" *"));
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"Process\" *"));
        greps.add(new ProcessBuilder("/bin/sh", "-c", "grep -c \"onExit\" *"));
        ProcTwo.startSeveralProcesses(greps, ProcTwo::printGrepResults);
        System.out.println("\nPress enter to continue ...\n");
        System.in.read();
    }

    static void startSeveralProcesses(
            List<ProcessBuilder> pBList,
            Consumer<Process> onExitMethod) throws InterruptedException {
        System.out.println("Number of processes: " + pBList.size());
        pBList.stream().forEach(
                pb -> {
                    try {
                        Process p = pb.start();
                        System.out.printf("Start %d, %s%n",
                                p.pid(), p.info().commandLine().orElse("<na>"));
                        p.onExit().thenAccept(onExitMethod);

                        p.onExit().get();
                        printGrepResults(p);

                    } catch (IOException | InterruptedException | ExecutionException e) {
                        System.err.println("Exception caught");
                        e.printStackTrace();
                    }
                }
        );
    }

    static void printGrepResults(Process p) {
        System.out.printf("Exit %d, status %d%n%s%n%n",
                p.pid(), p.exitValue(), output(p.getInputStream()));
    }

    private static String output(InputStream inputStream) {
        String s = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            s = br.lines().collect(Collectors.joining(System.getProperty("line.separator")));
        } catch (IOException e) {
            System.err.println("Caught IOException");
            e.printStackTrace();
        }
        return s;
    }


}
