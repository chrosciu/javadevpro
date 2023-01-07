package com.chrosciu.shop.payments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentStatusTest {

    @ParameterizedTest
    @MethodSource
    public void shouldProperlyCalculateIsNegativeFlag(PaymentStatus pStatus, boolean expectedFlagValue) {
        //when
        boolean isNegative =  pStatus.isNegative();

        //then
        assertThat(isNegative).isEqualTo(expectedFlagValue);
    }

    static Stream<Arguments> shouldProperlyCalculateIsNegativeFlag() {
        return Stream.of(
                Arguments.of(PaymentStatus.STARTED, false),
                Arguments.of(PaymentStatus.CONFIRMED, false),
                Arguments.of(PaymentStatus.FAILED, true),
                Arguments.of(PaymentStatus.CANCELED, true)
        );
    }
}
