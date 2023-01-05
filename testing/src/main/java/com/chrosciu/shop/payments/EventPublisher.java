package com.chrosciu.shop.payments;

public interface EventPublisher {
    void publishEvent(PaymentStatusChangedEvent paymentStatusChangedEvent);
}
