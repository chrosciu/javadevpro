package com.chrosciu.shop.payments;

import lombok.Getter;

import java.util.List;

@Getter
public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(List<String> messages) {
        super(String.join(",", messages));
    }
}
