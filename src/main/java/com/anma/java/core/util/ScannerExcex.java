package com.anma.java.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerExcex {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = scan.next();
        String s2 = scan.nextLine();



        // Write your code here.

        System.out.println("String: " + s + s2);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }

    private static void systemIn() {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            strs.add(scanner.next());
        }
        strs.forEach(System.out::println);
    }

    private static void stringScanner() {
        Scanner scanner = new Scanner("hello one hello two hello three!").useDelimiter("\\s*hello");
        System.out.println(scanner.next());
        System.out.println(scanner.next());
    }

    private static void fileScanner() throws FileNotFoundException {
        Scanner scanner2 = new Scanner(new File("src/resources/numbers-1.txt"));
        System.out.println(scanner2.nextInt());
        System.out.println(scanner2.nextInt());
        System.out.println(scanner2.nextInt());
    }

}
