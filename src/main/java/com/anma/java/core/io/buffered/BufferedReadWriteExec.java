package com.anma.java.core.io.buffered;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BufferedReadWriteExec {

    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());
        strings.add(reader.readLine());

//        System.out.println(Collections.max(strings));;

        int max = 0;

//        String[] arr = new String[5];
//        arr[0] = one;
//        arr[1] = two;
//        arr[2] = three;
//        arr[3] = four;
//        arr[4] = five;
//        int max = 0;

        for (String str : strings) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        for (String str : strings) {
            if (str.length() == max) {
                System.out.println(str);
            }
        }
        /*for (int i = 0; i < strings.size(); i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }*/


        /*for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == max) {
                System.out.println(arr[i]);
            }
        }*/




    }

    private static void misc() throws IOException {
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
