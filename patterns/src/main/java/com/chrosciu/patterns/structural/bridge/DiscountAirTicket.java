package com.chrosciu.patterns.structural.bridge;

class DiscountAirTicket extends Ticket {
    @Override
    String getTransportationType() {
        return "air";
    }

    @Override
    String getPriceType() {
        return "discount";
    }
}
