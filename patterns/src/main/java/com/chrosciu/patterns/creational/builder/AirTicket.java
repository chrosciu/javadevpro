package com.chrosciu.patterns.creational.builder;

class AirTicket extends Ticket {
    public AirTicket(Price price) {
        super(price);
    }

    @Override
    String getTransportationType() {
        return "air";
    }
}
