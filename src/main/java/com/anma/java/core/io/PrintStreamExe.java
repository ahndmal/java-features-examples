package com.anma.java.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamExe {
    
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream printStream = new PrintStream(new File("src/resources/text2.txt"));
        PrintStream printStream2 = new PrintStream(System.out);
        printStream2.println("AAAA");
    }
}
