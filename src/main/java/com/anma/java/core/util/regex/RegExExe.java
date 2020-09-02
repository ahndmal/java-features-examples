package com.anma.java.core.util.regex;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExe {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("An[dfg]ri*");
        Matcher matcher = pattern.matcher("Andrii");

        boolean matches = matcher.matches();
        boolean matches2 = Pattern.matches("a*b", "aaaaab");

        MatchResult matchResult = matcher.toMatchResult();
        System.out.println(matchResult.start());
        System.out.println(matchResult.end());

        System.out.println(matches);
        System.out.println(matches2);
        System.out.println(Pattern.quote("Hello there!"));
    }
}
