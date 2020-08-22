package com.anma.java.core.io;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderExec {

    public static void main(String[] args) throws IOException {

        char[] chars = new char[] {'A', 'B', 'C'};
        CharArrayReader charArrayReader = new CharArrayReader(chars);

        int read1 = charArrayReader.read();
        System.out.println(read1);
    }
}
