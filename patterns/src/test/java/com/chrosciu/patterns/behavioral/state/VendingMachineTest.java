package com.chrosciu.patterns.behavioral.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {
    private final List<String> events = new ArrayList<>();

    @AfterEach
    void cleanUp() {
        events.clear();
    }

    @Test
    void shouldSellAvailableProductsForInsertedMoney() {
        //given
        var vendingMachine = new VendingMachine(10);

        //when
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(1));
        events.add(vendingMachine.refill(3));
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(20));
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(10));
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(5));
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(5));
        events.add(vendingMachine.cancelPurchase());
        events.add(vendingMachine.insertMoney(5));
        events.add(vendingMachine.insertMoney(5));
        events.add(vendingMachine.dispenseProduct());
        events.add(vendingMachine.insertMoney(20));

        //then
        assertThat(events).containsExactly(
                "Items sold out",
                "Cannot accept money - items sold out",
                "Machine refilled",
                "Cannot dispense product - amount 10 must be paid",
                "Money accepted",
                "Dispensing product and change 10",
                "Money accepted",
                "Dispensing product and change 0",
                "Money accepted",
                "Cannot dispense product - amount 5 must be paid",
                "Money accepted",
                "Returning 10",
                "Money accepted",
                "Money accepted",
                "Dispensing product and change 0",
                "Cannot accept money - items sold out"
        );
    }
}
