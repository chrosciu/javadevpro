package com.chrosciu.calculator;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void whenAddMethodIsCalledNoCompilationErrorShouldOccur() {
        StringCalculator.add("1,2");
    }
}
