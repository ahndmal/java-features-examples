package com.anma.java.core.proc;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processes {
    public static void processes() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("echo", "Hello from Java!").inheritIO();
        processBuilder.start().waitFor();
    }

    public static void setEnvTest() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "echo $horse $dog $HOME").inheritIO();
        pb.environment().put("horse", "oats");
        pb.environment().put("dog", "treats");
        pb.start().waitFor();
    }

    public static void getInfoTest() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("echo", "Hello World!");
        String na = "<not available>";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID: %s%n", p.pid());
        System.out.printf("Command name: %s%n", info.command().orElse(na));
        System.out.printf("Command line: %s%n", info.commandLine().orElse(na));

        System.out.printf("Start time: %s%n",
                info.startInstant().map((Instant i) -> i
                                .atZone(ZoneId.systemDefault()).toLocalDateTime().toString())
                        .orElse(na));

        System.out.printf("Arguments: %s%n",
                info.arguments().map(
                                (String[] a) -> Stream.of(a).collect(Collectors.joining(" ")))
                        .orElse(na));

        System.out.printf("User: %s%n", info.user().orElse(na));
    }

    public static void redirectToFileTest() throws IOException, InterruptedException {
        File outFile = new File("out.tmp");
        Process p = new ProcessBuilder("ls", "-la")
                .redirectOutput(outFile)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start();
        int status = p.waitFor();
        if (status == 0) {
            p = new ProcessBuilder("cat" , outFile.toString())
                    .inheritIO()
                    .start();
            p.waitFor();
        }
    }

    static void filterProcessesTest() {
        Optional<String> currUser = ProcessHandle.current().info().user();
        ProcessHandle.allProcesses()
                .filter(p1 -> p1.info().user().equals(currUser))
                .sorted(Processes::parentComparator)
                .forEach(Processes::showProcess);
    }

    static int parentComparator(ProcessHandle p1, ProcessHandle p2) {
        long pid1 = p1.parent().map(ph -> ph.pid()).orElse(-1L);
        long pid2 = p2.parent().map(ph -> ph.pid()).orElse(-1L);
        return Long.compare(pid1, pid2);
    }

    static void showProcess(ProcessHandle ph) {
        ProcessHandle.Info info = ph.info();
        System.out.printf("pid: %d, user: %s, cmd: %s%n",
                ph.pid(), info.user().orElse("none"), info.command().orElse("none"));
    }
}
