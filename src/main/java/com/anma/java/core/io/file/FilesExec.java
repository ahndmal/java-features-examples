package com.anma.java.core.io.file;

import java.io.*;
import java.net.URISyntaxException;

public class FilesExec {

    public static void main(String[] args) throws URISyntaxException, IOException {

        readFileWithBuffer();

    }

    private static void readerWriter() throws IOException {
        FileReader reader = new FileReader("src/resources/text2.txt");
        FileReader reader2 = new FileReader(new File("src/resources/text2.txt"));
        int read = reader.read();
        System.out.println(read);
        reader.close();

        FileWriter writer = new FileWriter("src/resources/text2-new.txt");
        writer.write("HHHHHHHHHHHHHHHHH");
        writer.close();
    }

    private static void readFileWithBuffer() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/text2.txt"));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("src/resources/text2.txt")));

        String line = bufferedReader.readLine();
        System.out.println(line);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/resources/text2-new.txt"));
        bufferedWriter.write(line);

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void readFileWithBufferFromSystem() throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
    }

    private static void fileInputstream1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/resources/text2.txt");
        int read = fileInputStream.read();
        System.out.println(read);
    }

    private static void fileUrl() throws URISyntaxException {

        File file2 = new File(new File("XXXXXX").toURI());

        System.out.println(file2.getPath());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
    }

    private static void file1() {

        File file = new File("src/resources/text2.txt");

        System.out.println(file.getPath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}
