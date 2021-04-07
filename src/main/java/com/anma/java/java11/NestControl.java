package com.anma.java.java11;

import java.lang.reflect.Field;

public class NestControl {

}

class Outer {

    private static String level = "outer";

    public static class Inner {
        public static String getOuterViaRegularFieldAccess() {
            return Outer.level;
        }

        public static String getOuterViaReflection() {
            try {
                Field levelField = Outer.class
                        .getDeclaredField("level");
// levelField.setAccessible(true);
                return levelField.get(null).toString();
            } catch (NoSuchFieldException
                    | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Inner.getOuterViaRegularFieldAccess();
        Inner.getOuterViaReflection();
    }
}

