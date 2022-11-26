package com.chrosciu.patterns.behavioral.interpreter;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Literal implements Expression {
    private final double value;

    @Override
    public double evaluate(Map<String, Double> context) {
        //TODO: Implement
        throw new UnsupportedOperationException();
    }

}
