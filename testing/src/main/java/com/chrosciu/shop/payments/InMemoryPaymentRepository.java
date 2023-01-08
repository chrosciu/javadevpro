package com.chrosciu.shop.payments;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final Map<String, Payment> payments = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }
}
