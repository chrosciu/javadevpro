package com.chrosciu.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

public class StringCalculatorTest {
    @Test
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        assertThatRuntimeException().isThrownBy(() -> StringCalculator.add("1,2,3"));

    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        assertThatNoException().isThrownBy(() -> StringCalculator.add("1,2"));

    }
    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        assertThatRuntimeException().isThrownBy(() -> StringCalculator.add("1,X"));
    }
    @Test
    public final void whenEmptyStringIsUsedThenNoExceptionIsThrown() {
        assertThatNoException().isThrownBy(() -> StringCalculator.add(""));
    }

}
