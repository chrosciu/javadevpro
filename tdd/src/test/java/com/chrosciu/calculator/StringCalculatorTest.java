package com.chrosciu.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class StringCalculatorTest {
    @Test
    public void whenAddMethodIsCalledNoCompilationErrorShouldOccur() {
        assertThatNoException().isThrownBy(() -> {
            int result = StringCalculator.add("1,2");
        });
    }
}
