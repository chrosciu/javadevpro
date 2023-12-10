package com.chrosciu.patterns.structural.bridge;

class RegularRailwayTicket extends Ticket {
    @Override
    String getTransportationType() {
        return "railway";
    }

    @Override
    String getPriceType() {
        return "regular";
    }
}
