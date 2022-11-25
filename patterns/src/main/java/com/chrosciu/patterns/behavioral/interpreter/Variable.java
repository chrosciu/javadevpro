package com.chrosciu.patterns.behavioral.interpreter;

import java.util.Map;

public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        return context.get(name);
    }
}
