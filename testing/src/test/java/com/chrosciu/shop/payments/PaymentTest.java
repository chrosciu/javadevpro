package com.chrosciu.shop.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

import static com.chrosciu.shop.payments.PaymentStatus.STARTED;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PaymentTest {
    @ParameterizedTest(name = "{0}, {1}, {2} => {3}")
    @DisplayName("Should not be valid")
    @MethodSource
    void shouldNotBeValid(FastMoney money, Instant timestamp, PaymentStatus status, List<String> messages) {
        //given
        Payment payment = Payment.builder().money(money).timestamp(timestamp).status(status).build();

        //when / then
        assertThatExceptionOfType(InvalidPaymentException.class)
                .isThrownBy(payment::validate)
                .withMessageContainingAll(messages.toArray(new String[0]));
    }

    @ParameterizedTest(name = "{0}, {1}, {2}")
    @DisplayName("Should be valid")
    @MethodSource
    void shouldBeValid(FastMoney money, Instant timestamp, PaymentStatus status) {
        //given
        Payment payment = Payment.builder().money(money).timestamp(timestamp).status(status).build();

        //then
        assertThatCode(payment::validate).doesNotThrowAnyException();
    }

    static Stream<Arguments> shouldNotBeValid() {
        return Stream.of(
                Arguments.of(null, null, null, List.of("money", "status"))
        );
    }

    static Stream<Arguments> shouldBeValid() {
        return Stream.of(
                Arguments.of(FastMoney.of(100, "PLN"), Instant.now(), STARTED)
        );
    }

}
