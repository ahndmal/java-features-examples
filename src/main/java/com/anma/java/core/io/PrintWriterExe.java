package com.anma.java.core.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExe {

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("src/resources/created-by-writer.txt");
        writer.append("AAA").append("BBB");
        writer.write("GGG");
        writer.close();
    }
}
