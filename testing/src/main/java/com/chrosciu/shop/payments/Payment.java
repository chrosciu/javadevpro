package com.chrosciu.shop.payments;

import lombok.Builder;
import lombok.Data;
import org.javamoney.moneta.FastMoney;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Payment {
    String id;
    FastMoney money;
    Instant timestamp;
    PaymentStatus status;

    public void validate() {
        List<String> messages = new ArrayList<>();
        if (null == money) {
            messages.add("money");
        }
        if (null == timestamp) {
            messages.add("timestamp");
        }
        if (null == status) {
            messages.add("status");
        }
        if (!messages.isEmpty()) {
            throw new InvalidPaymentException(messages);
        }
    }
}
