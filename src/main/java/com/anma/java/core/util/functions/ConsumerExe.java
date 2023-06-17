package com.anma.java.core.util.functions;

import java.util.Random;
import java.util.function.*;

public class ConsumerExe {
    public static void main(String[] args) {
        BiConsumer<String, String> consumer = (s, s2) -> {
            System.out.println(s + s2);
        };

        BiFunction biFunction = new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) {
                return o.equals(o2);
            }
        };
        biFunction.apply("a", "b");

        BinaryOperator binaryOperator = (o, o2) -> null;

        BiPredicate biPredicate = new BiPredicate() {
            @Override
            public boolean test(Object o, Object o2) {
                return o.equals(o2);
            }
        };

        BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();
        DoubleConsumer doubleConsumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {

            }
        };

        Function function = o -> "function result";

        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                // action
            }
        };

        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };

        LongUnaryOperator longUnaryOperator = new LongUnaryOperator() {
            @Override
            public long applyAsLong(long operand) {
                return 0;
            }
        };

        ToLongFunction toLongFunction = value -> (long) value;

    }
}
