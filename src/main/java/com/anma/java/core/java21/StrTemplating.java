package com.anma.java.core.java21;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import static java.lang.StringTemplate.STR;

public class StrTemplating {

    record Rectangle(String name, double width, double height) {
        double area() {
            return width * height;
        }
    }

    Rectangle[] zone = new Rectangle[] {
            new Rectangle("First",  17.8, 31.4),
            new Rectangle("Second",  9.6, 12.2),
    };

    String table = STR."""
    Description\tWidth\tHeight\tArea
    \{zone[0].name}\t\t\{zone[0].width}\t\{zone[0].height}\t\{zone[0].area()}
    \{zone[1].name}\t\t\{zone[1].width}\t\{zone[1].height}\t\{zone[1].area()}
    Total \{zone[0].area() + zone[1].area()}
    """;

    System.out.println(table);
    void templating() {
        String time = STR."Today is \{java.time.LocalDate.now()}";
        System.out.println(time);
        String canLang = STR."The language code of \{
            Locale.CANADA_FRENCH} is \{
            Locale.CANADA_FRENCH.getLanguage()}";

        System.out.println(canLang);
    }

    void templateTwo() {
        Path filePath = Paths.get("Stemp.java");
        String msg = STR."The file \{filePath} \{
        // The Files class is in the package java.nio.file
        Files.exists(filePath) ? "does" : "does not"} exist";
        System.out.println(msg);

        String currentTime = STR."The time is \{
        DateTimeFormatter
        .ofPattern("HH:mm:ss")
        .format(LocalTime.now())
        } right now";
        System.out.println(currentTime);

    }


}
