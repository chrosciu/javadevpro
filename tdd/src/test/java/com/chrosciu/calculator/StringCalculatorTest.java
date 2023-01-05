package com.chrosciu.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }
    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertThat(StringCalculator.add("3")).isEqualTo(3);
    }
    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertThat(StringCalculator.add("3,6")).isEqualTo(9);
    }
}