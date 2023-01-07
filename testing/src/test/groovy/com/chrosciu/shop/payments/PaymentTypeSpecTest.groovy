package com.chrosciu.shop.payments

import spock.lang.Specification
import spock.lang.Unroll

import static com.chrosciu.shop.payments.PaymentStatus.CANCELED
import static com.chrosciu.shop.payments.PaymentStatus.CONFIRMED
import static com.chrosciu.shop.payments.PaymentStatus.FAILED
import static com.chrosciu.shop.payments.PaymentStatus.STARTED

class PaymentTypeSpecTest extends Specification {

    @Unroll("#status => #expectedNegative")
    def "should properly calculate negative flag"(PaymentStatus status, boolean expectedNegative) {
        when:
        def negative = status.negative

        then:
        negative == expectedNegative

        where:
        status    | expectedNegative
        STARTED   | false
        CONFIRMED | false
        CANCELED  | true
        FAILED    | true
    }
}
