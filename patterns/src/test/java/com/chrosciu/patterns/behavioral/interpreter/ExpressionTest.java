package com.chrosciu.patterns.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    @Test
    public void shouldProperlyCalculateValue() {
        // (2a + 3) * 4 gdzie a = 4
        Expression expression = new Operation(
                new Operation(
                        new Operation(new Literal(2), new Variable("a"), Operators.create("*")),
                        new Literal(3),
                        Operators.create("+")),
                new Literal(4),
                Operators.create("*"));

        Map<String, Double> context = Map.of("a", 4.0);
        double result = expression.evaluate(context);

        assertThat(result).isEqualTo(44.0);
    }
}
