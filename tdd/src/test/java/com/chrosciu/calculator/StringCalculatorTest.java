package com.chrosciu.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

public class StringCalculatorTest {
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
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertThat(StringCalculator.add("3,6,15,18")).isEqualTo(42);
    }
    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertThat(StringCalculator.add("3,6\n15")).isEqualTo(24);
    }
    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        assertThat(StringCalculator.add("//;\n3;6;15")).isEqualTo(24);
    }
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        assertThatRuntimeException()
                .isThrownBy(() -> StringCalculator.add("3,-6,15,-18,46,33"))
                .withMessage("Negatives not allowed: [-6, -18]");
    }
    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        assertThat(StringCalculator.add("3,1000,1001,6,1234")).isEqualTo(1009);
    }
}
