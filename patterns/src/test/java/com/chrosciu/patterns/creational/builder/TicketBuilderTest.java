package com.chrosciu.patterns.creational.builder;

import org.junit.jupiter.api.Test;

import static com.chrosciu.patterns.creational.builder.TicketBuilder.PriceType.DISCOUNT;
import static com.chrosciu.patterns.creational.builder.TicketBuilder.PriceType.FLEX;
import static com.chrosciu.patterns.creational.builder.TicketBuilder.PriceType.REGULAR;
import static com.chrosciu.patterns.creational.builder.TicketBuilder.TicketType.AIR;
import static com.chrosciu.patterns.creational.builder.TicketBuilder.TicketType.FERRY;
import static com.chrosciu.patterns.creational.builder.TicketBuilder.TicketType.RAILWAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

class TicketBuilderTest {
    @Test
    void regularAirTicket() {
        //when
        var ticket = TicketBuilder.create()
                .ticketType(AIR)
                .priceType(REGULAR)
                .build();

        //then
        assertThat(ticket)
                .returns("air", from(Ticket::getTransportationType))
                .returns("regular", from(Ticket::getPriceType));
    }

    @Test
    void discountRailwayTicket() {
        //given
        var ticket = TicketBuilder.create()
                .ticketType(RAILWAY)
                .priceType(DISCOUNT)
                .build();

        //when / then
        assertThat(ticket)
                .returns("railway", from(Ticket::getTransportationType))
                .returns("discount", from(Ticket::getPriceType));
    }

    @Test
    void flexFerryTicket() {
        //given
        var ticket = TicketBuilder.create()
                .ticketType(FERRY)
                .priceType(FLEX)
                .build();

        //when / then
        assertThat(ticket)
                .returns("ferry", from(Ticket::getTransportationType))
                .returns("flex", from(Ticket::getPriceType));
    }
}
