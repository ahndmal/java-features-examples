package com.anma.java;


import org.apache.commons.codec.binary.StringUtils;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

public class MiscExec {

    enum Role {
        ROLE_ADMIN, ROLE_USER
    }

    public static void main(String[] args) {

        System.out.println(Role.ROLE_ADMIN.name() + "," + Role.ROLE_USER.name());
        System.out.println(Arrays.toString(Role.values()));

    }
}
