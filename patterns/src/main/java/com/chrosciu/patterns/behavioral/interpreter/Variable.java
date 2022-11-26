package com.chrosciu.patterns.behavioral.interpreter;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Variable implements Expression {
    private final String name;

    @Override
    public double evaluate(Map<String, Double> context) {
        //TODO: Implement
        throw new UnsupportedOperationException();
    }
}
