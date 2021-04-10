package com.anma.java.exam.nio;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class IOStream {

    public static void main(String[] args) throws IOException {

        Console console = System.console();
        PrintWriter writer = console.writer();
        writer.println("Hello!");

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             Files.newInputStream(Path.of(URI.create("text2.txt")), StandardOpenOption.READ))) {

        }


    }
}
