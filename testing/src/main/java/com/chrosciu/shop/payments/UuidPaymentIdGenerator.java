package com.chrosciu.shop.payments;

import java.util.UUID;

public class UuidPaymentIdGenerator implements PaymentIdGenerator {
    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }
}
