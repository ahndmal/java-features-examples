package com.anma.java.core.lang;

public class LangMIscExe {

    public static void main(String[] args) {

        boolean[] arr = new boolean[] {true, false, true, false, true};

        for (Boolean a : arr) {
            if (a != null) {
                System.out.println(a);
            }
        }

    }

    private static void bytes() {
        Byte b1 = new Byte((byte) 12);
        System.out.println(b1.byteValue());
    }

    private static void booleans() {
        Boolean boolean1 = Boolean.TRUE;
//        System.out.println(boolean1);

        Boolean bool2 = new Boolean(true);
//        System.out.println(bool2.booleanValue());

        Boolean bool3 = new Boolean("true");

        boolean boolPrimitive = Boolean.parseBoolean("true");
        Boolean boolObj = Boolean.valueOf("true");
    }

    private static void numbersValues() {

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
    }
}
