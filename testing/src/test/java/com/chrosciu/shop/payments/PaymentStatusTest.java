package com.chrosciu.shop.payments;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.chrosciu.shop.payments.PaymentStatus.CANCELED;
import static com.chrosciu.shop.payments.PaymentStatus.CONFIRMED;
import static com.chrosciu.shop.payments.PaymentStatus.FAILED;
import static com.chrosciu.shop.payments.PaymentStatus.STARTED;

public class PaymentStatusTest {
    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource
    @DisplayName("Negative flag should be properly calculated")
    public void negativeFlagShouldBeProperlyCalculated(PaymentStatus paymentStatus, boolean expected) {
        Assertions.assertThat(paymentStatus.isNegative()).isEqualTo(expected);
    }

    static Stream<Arguments> negativeFlagShouldBeProperlyCalculated() {
        return Stream.of(
                Arguments.of(STARTED, false),
                Arguments.of(CONFIRMED, false),
                Arguments.of(FAILED, true),
                Arguments.of(CANCELED, true)
        );
    }

}
