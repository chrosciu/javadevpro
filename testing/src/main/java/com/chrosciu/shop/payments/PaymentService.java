package com.chrosciu.shop.payments;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentService {
    private final PaymentIdGenerator paymentIdGenerator;
    private final PaymentRepository paymentRepository;
    private final EventPublisher eventPublisher;

    public Payment process(PaymentRequest paymentRequest) {
        var payment = Payment.builder()
                .id(paymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .status(PaymentStatus.STARTED)
                .build();
        payment.validate();
        eventPublisher.publishEvent(new PaymentStatusChangedEvent(this, payment));
        return paymentRepository.save(payment);
    }
}
