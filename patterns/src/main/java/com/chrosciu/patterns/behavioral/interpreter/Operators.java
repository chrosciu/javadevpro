package com.chrosciu.patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Operators {
    private static final Map<String, Operator> operators = new HashMap<>();

    public static Operator create(String name) {
        return operators.computeIfAbsent(name, Operators::operatorFactory);
    }

    private static Operator operatorFactory(String name) {
        switch (name) {
            case "+":
                return Double::sum;
            case "-":
                return (a, b) -> a - b;
            case "*":
                return (a, b) -> a * b;
            default:
                throw new IllegalArgumentException();
        }
    }
}
