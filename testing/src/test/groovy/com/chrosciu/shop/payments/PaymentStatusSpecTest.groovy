package com.chrosciu.shop.payments


import spock.lang.Specification
import spock.lang.Unroll

import static com.chrosciu.shop.payments.PaymentStatus.*

class PaymentStatusSpecTest extends Specification {
    @Unroll("#paymentStatus => #negative")
    def "Negative flag should be properly calculated"(PaymentStatus paymentStatus, boolean negative) {
        expect:
        paymentStatus.negative == negative

        where:
        paymentStatus | negative
        CONFIRMED     | false
        CANCELED      | true
        STARTED       | false
        FAILED        | true
    }
}
