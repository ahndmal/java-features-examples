package com.anma.java;


import org.apache.commons.codec.binary.StringUtils;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class MiscExec {

    enum Role {
        ROLE_ADMIN, ROLE_USER
    }

    public static void main(String[] args) {

        System.out.println(MiscExec.class.getClassLoader().getResource("text2.txt"));
        System.out.println(MiscExec.class.getClassLoader().getResourceAsStream ("text2.txt"));
//        System.out.println(ResourceBundle.getBundle().getString("text2.txt"));

    }
}
