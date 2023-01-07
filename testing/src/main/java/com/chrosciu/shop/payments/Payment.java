package com.chrosciu.shop.payments;

import lombok.Builder;
import lombok.Data;
import org.javamoney.moneta.FastMoney;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Payment {
    String id;
    FastMoney money;
    PaymentStatus status;

    public void validate() {
        List<String> messages = new ArrayList<>();
        if (null == id) {
            messages.add("id");
        }
        if (null == money) {
            messages.add("money");
        }
        if (null == status) {
            messages.add("status");
        }
        if (!messages.isEmpty()) {
            throw new InvalidPaymentException(messages);
        }
    }
}
