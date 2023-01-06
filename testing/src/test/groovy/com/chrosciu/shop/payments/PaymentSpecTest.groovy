package com.chrosciu.shop.payments

import org.javamoney.moneta.FastMoney
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Instant

import static com.chrosciu.shop.payments.PaymentStatus.STARTED

class PaymentSpecTest extends Specification {
    @Unroll("#money, #timestamp, #status => #messages")
    def "Should not be valid"(FastMoney money, Instant timestamp, PaymentStatus status, List<String> messages) {
        given:
        def payment = Payment.builder().money(money).timestamp(timestamp).status(status).build()

        when:
        payment.validate()

        then:
        def e = thrown(InvalidPaymentException)
        messages.each {assert e.message.contains(it)}

        where:
        money | timestamp | status | messages
        null  | null      | null   | ["money", "status"]
    }

    @Unroll("#money, #timestamp, #status")
    def "Should be valid"(FastMoney money, Instant timestamp, PaymentStatus status) {
        given:
        def payment = Payment.builder().money(money).timestamp(timestamp).status(status).build()

        when:
        payment.validate()

        then:
        noExceptionThrown()

        where:
        money                    | timestamp     | status
        FastMoney.of(100, "PLN") | Instant.now() | STARTED
    }
}
