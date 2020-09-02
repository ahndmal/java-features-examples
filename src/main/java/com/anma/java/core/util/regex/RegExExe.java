package com.anma.java.core.util.regex;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExe {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaab");
        
        boolean matches = matcher.matches();
        boolean matches2 = Pattern.matches("a*b", "aaaaab");

        MatchResult matchResult = matcher.toMatchResult();

        System.out.println(matches);
    }
}
