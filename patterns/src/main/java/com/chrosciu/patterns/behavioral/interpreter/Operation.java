package com.chrosciu.patterns.behavioral.interpreter;

import java.util.Map;

public class Operation implements Expression {
    private final Expression firstExpression;
    private final Expression secondExpression;
    private final Operator operator;

    public Operation(Expression firstExpression, Expression secondExpression, Operator operator) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operator = operator;
    }

    @Override
    public double evaluate(Map<String, Double> context) {
        return operator.apply(firstExpression.evaluate(context), secondExpression.evaluate(context));
    }
}
