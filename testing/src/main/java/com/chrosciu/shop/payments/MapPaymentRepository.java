package com.chrosciu.shop.payments;

import java.util.HashMap;
import java.util.Map;

public class MapPaymentRepository implements PaymentRepository {
    private final Map<String, Payment> paymentMap = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        paymentMap.put(payment.getId(), payment);
        return payment;
    }
}
