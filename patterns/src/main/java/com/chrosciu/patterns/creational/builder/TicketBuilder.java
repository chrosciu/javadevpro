package com.chrosciu.patterns.creational.builder;

class TicketBuilder {
    enum TicketType {
        AIR,
        RAILWAY,
        FERRY
    }

    enum PriceType {
        REGULAR,
        DISCOUNT,
        FLEX
    }

    static TicketBuilder create() {
        return null;
    }

    TicketBuilder ticketType(TicketType ticketType) {
        return null;
    }

    TicketBuilder priceType(PriceType priceType) {
        return null;
    }

    Ticket build() {
        return null;
    }
}
