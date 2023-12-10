package com.chrosciu.patterns.structural.bridge;

class AirTicket extends Ticket {
    public AirTicket(Price price) {
        super(price);
    }

    @Override
    String getTransportationType() {
        return "air";
    }
}
