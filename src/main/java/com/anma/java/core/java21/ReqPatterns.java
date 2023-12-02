package com.anma.java.core.java21;

public class ReqPatterns {

    interface Shape {
    }

    record Rectangle(double length, double width) implements Shape {
    }

    record Circle(double radius) implements Shape {
    }

    public static double getPerimeter(Shape s) throws IllegalArgumentException {
        if (s instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static double getPerimeterSwitchExpr(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    public static double getPerimeterSwitchStatement(Shape s) throws IllegalArgumentException {
        switch (s) {
            case Rectangle r:
                return 2 * r.length() + 2 * r.width();
            case Circle c:
                return 2 * c.radius() * Math.PI;
            default:
                throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    // When Clauses
    static void test(Object obj) {
        switch (obj) {
            case String s:
                if (s.length() == 1) {
                    System.out.println("Short: " + s);
                } else {
                    System.out.println(s);
                }
                break;
            default:
                System.out.println("Not a string");
        }
    }

    static void testExpr(Object obj) {
        switch (obj) {
            case String s when s.length() == 1 -> System.out.println("Short: " + s);
            case String s -> System.out.println(s);
            default -> System.out.println("Not a string");
        }
    }


    // Qualified enum Constants as case Constants

    public enum Standard {SPADE, HEART, DIAMOND, CLUB}

    static void determineSuitStandardDeck(Standard d) {
        switch (d) {
            case SPADE -> System.out.println("Spades");
            case HEART -> System.out.println("Hearts");
            case DIAMOND -> System.out.println("Diamonds");
            default -> System.out.println("Clubs");
        }
    }

    sealed interface CardClassification permits Standard2, Tarot {
    }

    public enum Standard2 implements CardClassification {SPADE, HEART, DIAMOND, CLUB}

    public enum Tarot implements CardClassification {SPADE, HEART, DIAMOND, CLUB, TRUMP, EXCUSE}

    static void determineSuit(CardClassification c) {
        switch (c) {
            case Standard2 s when s == Standard2.SPADE -> System.out.println("Spades");
            case Standard2 s when s == Standard2.HEART -> System.out.println("Hearts");
            case Standard2 s when s == Standard2.DIAMOND -> System.out.println("Diamonds");
            case Standard2 s -> System.out.println("Clubs");
            case Tarot t when t == Tarot.SPADE -> System.out.println("Spades or Piques");
            case Tarot t when t == Tarot.HEART -> System.out.println("Hearts or C\u0153ur");
            case Tarot t when t == Tarot.DIAMOND -> System.out.println("Diamonds or Carreaux");
            case Tarot t when t == Tarot.CLUB -> System.out.println("Clubs or Trefles");
            case Tarot t when t == Tarot.TRUMP -> System.out.println("Trumps or Atouts");
            case Tarot t -> System.out.println("The Fool or L'Excuse");
        }
    }
}
