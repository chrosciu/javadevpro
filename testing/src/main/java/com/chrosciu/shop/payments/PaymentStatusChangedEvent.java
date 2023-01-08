package com.chrosciu.shop.payments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class PaymentStatusChangedEvent {
    private final Object source;
    private final Payment payment;
}
