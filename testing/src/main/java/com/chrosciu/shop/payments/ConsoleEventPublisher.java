package com.chrosciu.shop.payments;

public class ConsoleEventPublisher implements EventPublisher {
    @Override
    public void publishEvent(PaymentStatusChangedEvent paymentStatusChangedEvent) {
        System.out.println(paymentStatusChangedEvent);
    }
}
