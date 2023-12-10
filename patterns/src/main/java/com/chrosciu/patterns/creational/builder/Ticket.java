package com.chrosciu.patterns.creational.builder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class Ticket {
    protected final Price price;
    abstract String getTransportationType();

    String getPriceType() {
        return price.getPriceType();
    }
}
