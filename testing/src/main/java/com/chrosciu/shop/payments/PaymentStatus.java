package com.chrosciu.shop.payments;

import java.util.EnumSet;

public enum PaymentStatus {
    STARTED, CONFIRMED, FAILED, CANCELED;

    private static EnumSet<PaymentStatus> NEGATIVES = EnumSet.of(FAILED, CANCELED);

    public boolean isNegative() {
        return NEGATIVES.contains(this);
    }
}
