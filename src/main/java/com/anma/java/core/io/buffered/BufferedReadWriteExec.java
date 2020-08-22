package com.anma.java.core.io.buffered;

import java.io.*;

public class BufferedReadWriteExec {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/resources/text2.txt"));

        String line = bufferedReader2.readLine();
        System.out.println(line);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/resources/text2-new.txt"));
        bufferedWriter.write(line);

        bufferedReader.close();
        bufferedReader2.close();
        bufferedWriter.close();


    }
}
