package com.anma.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpExe {

    public static void main(String[] args) {

        String pattern = "(FC-[a-z])";
        String text = "FC-OOB-OM-001";

        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            System.out.println(true);
        }
    }
}
