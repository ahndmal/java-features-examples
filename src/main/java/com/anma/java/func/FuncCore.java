package com.anma.java.func;


// https://github.com/openjdk/jdk/blob/dfacda488bfbe2e11e8d607a6d08527710286982/src/java.base/share/classes/java/util/function/Predicate.java

import java.util.function.Predicate;

public class FuncCore {

    static void predicateMajor() {

        Predicate<String> predicate = s -> s.length() > 0;

        System.out.println(predicate.test("abc"));
    }

}
