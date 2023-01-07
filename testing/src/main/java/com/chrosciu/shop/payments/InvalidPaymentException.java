package com.chrosciu.shop.payments;

import java.util.List;

public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(List<String> messages) {
        super(String.join(",", messages));
    }
}
