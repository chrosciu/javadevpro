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

    private TicketType ticketType;
    private PriceType priceType;

    static TicketBuilder create() {
        return new TicketBuilder();
    }

    TicketBuilder ticketType(TicketType ticketType) {
        this.ticketType = ticketType;
        return this;
    }

    TicketBuilder priceType(PriceType priceType) {
        this.priceType = priceType;
        return this;
    }

    Ticket build() {
        if (null == ticketType) {
            throw new IllegalStateException("Ticket type is not set");
        }
        if (null == priceType) {
            throw new IllegalStateException("Price type is not set");
        }
        Price price = createPrice();
        return createTicket(price);
    }

    private Price createPrice() {
        switch (priceType) {
            case REGULAR:
                return new RegularPrice();
            case DISCOUNT:
                return new DiscountPrice();
            case FLEX:
                return new FlexPrice();
            default:
                throw new IllegalStateException("Unknown price type");
        }
    }

    private Ticket createTicket(Price price) {
        switch (ticketType) {
            case AIR:
                return new AirTicket(price);
            case RAILWAY:
                return new RailwayTicket(price);
            case FERRY:
                return new FerryTicket(price);
            default:
                throw new IllegalStateException("Unknown ticket type");
        }
    }
}
