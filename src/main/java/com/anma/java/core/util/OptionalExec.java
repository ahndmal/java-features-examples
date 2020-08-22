package com.anma.java.core.util;

import java.util.Optional;

public class OptionalExec {

    public static void main(String[] args) {

        Optional optional = Optional.empty();
        Optional optional2 = Optional.of(2);
        //Optional optionalNull = Optional.of(null);
        Optional optional3 = Optional.ofNullable(3);


        System.out.println(optional.isEmpty());
        System.out.println(optional.orElse("Other value"));
        System.out.println(optional2.orElse(4));

    }


}
