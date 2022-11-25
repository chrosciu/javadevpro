package com.chrosciu.patterns.behavioral.interpreter;

import java.util.Map;

public class Literal implements Expression {
    private final double value;

    public Literal(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        return value;
    }
}
