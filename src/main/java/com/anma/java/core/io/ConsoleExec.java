package com.anma.java.core.io;

import java.io.Console;

public class ConsoleExec {
    public static void main(String[] args) {
        Console console = System.console();
        console.writer().print(11);
    }
}
