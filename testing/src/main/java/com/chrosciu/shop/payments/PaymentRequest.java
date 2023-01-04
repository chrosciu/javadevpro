package com.chrosciu.shop.payments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;

@RequiredArgsConstructor
@Getter
public class PaymentRequest {
    private final FastMoney money;
}