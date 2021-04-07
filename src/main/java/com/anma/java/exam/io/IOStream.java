package com.anma.java.exam.io;

import java.io.Console;
import java.io.PrintWriter;

public class IOStream {

    public static void main(String[] args) {

        Console console = System.console();
        PrintWriter writer = console.writer();
        writer.println("Hello!");
    }
}
