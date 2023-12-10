package com.chrosciu.patterns.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

class TicketTest {
    @Test
    void regularAirTicket() {
        //given
        var ticket = new AirTicket(new RegularPrice());

        //when / then
        assertThat(ticket)
                .returns("air", from(Ticket::getTransportationType))
                .returns("regular", from(Ticket::getPriceType));
    }

    @Test
    void discountRailwayTicket() {
        //given
        var ticket = new RailwayTicket(new DiscountPrice());

        //when / then
        assertThat(ticket)
                .returns("railway", from(Ticket::getTransportationType))
                .returns("discount", from(Ticket::getPriceType));
    }

    @Test
    void flexFerryTicket() {
        //given
        var ticket = new FerryTicket(new FlexPrice());

        //when / then
        assertThat(ticket)
                .returns("ferry", from(Ticket::getTransportationType))
                .returns("flex", from(Ticket::getPriceType));
    }
}
