package com.anma.java.reflect;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ReflExe {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, NoSuchFieldException, NoSuchAlgorithmException {

        Class ref1 = Class.forName("com.anma.java.reflect.ReflClassOne");
        System.out.println(ref1.getName());
        System.out.println(ref1.getDeclaredField("name"));

        Field[] fields = ref1.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Class annotType = ReflClassOne.class.getAnnotations()[0].annotationType();
        System.out.println(annotType);



    }
}
