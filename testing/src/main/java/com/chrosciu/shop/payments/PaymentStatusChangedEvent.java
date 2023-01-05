package com.chrosciu.shop.payments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PaymentStatusChangedEvent {
    private final Object source;
    private final Payment payment;
}
