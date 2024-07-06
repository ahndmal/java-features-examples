package com.anma.java.func;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodRefs {

    void references() {

        var now = LocalDate.now();

        // LAMBDA BASED ON EXISTING OBJECT
        Predicate<LocalDate> isAfterNowAsLambda = date -> LocalDate.now().plusDays(1).isAfter(now);

        // BOUND NON-STATIC METHOD REFERENCE
        Predicate<LocalDate> isAfterNowAsRef = now::isAfter;

        Predicate<LocalDate> isAfterNowAsRef2 = LocalDate.now()::isAfter;

        // BIND STATIC FIELD
        Function<Object, String> castToStr = String.class::cast;

        /////

        // LAMBDA
        Function<String, String> toLowerCaseLambda = str -> str.toLowerCase();

        // UNBOUND NON-STATIC METHOD REFERENCE
        Function<String, String> toLowerCaseRef = String::toLowerCase;



    }
}

class SuperClass {
    public String doWork(String input) {
        return "super: " + input;
    }
}

class SubClass extends SuperClass {
    @Override
    public String doWork(String input) {
        return "this: " + input;
    }

    public void superAndThis(String input) {
        Function<String, String> thisWorker = this::doWork;
        var thisResult = thisWorker.apply(input);
        System.out.println(thisResult);
        Function<String, String> superWorker = SubClass.super::doWork;
        var superResult = superWorker.apply(input);
        System.out.println(superResult);
    }
}