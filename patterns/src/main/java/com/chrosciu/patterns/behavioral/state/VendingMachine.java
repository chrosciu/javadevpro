package com.chrosciu.patterns.behavioral.state;

import lombok.RequiredArgsConstructor;

import static com.chrosciu.patterns.behavioral.state.VendingMachine.State.IDLE;
import static com.chrosciu.patterns.behavioral.state.VendingMachine.State.IN_PAYMENT;
import static com.chrosciu.patterns.behavioral.state.VendingMachine.State.AFTER_PAYMENT;
import static com.chrosciu.patterns.behavioral.state.VendingMachine.State.SOLD_OUT;

@RequiredArgsConstructor
class VendingMachine {
    enum State {
        IDLE,
        IN_PAYMENT,
        AFTER_PAYMENT,
        SOLD_OUT
    }

    private int productsAmount = 0;
    private int insertedMoneyAmount = 0;
    private final int productPrice;
    private State state = SOLD_OUT;

    public String insertMoney(int moneyAmount) {
        switch (state) {
            case SOLD_OUT:
                return "Cannot accept money - items sold out";
            case AFTER_PAYMENT:
                return "Already paid - please request dispensation";
            default:
                insertedMoneyAmount += moneyAmount;
                if (insertedMoneyAmount < productPrice) {
                    state = IN_PAYMENT;
                } else {
                    state = AFTER_PAYMENT;
                }
                return "Money accepted";

        }
    }

    public String dispenseProduct() {
        switch (state) {
            case SOLD_OUT:
                return "Items sold out";
            case AFTER_PAYMENT:
                var change = insertedMoneyAmount - productPrice;
                insertedMoneyAmount = 0;
                productsAmount--;
                if (productsAmount > 0) {
                    state = IDLE;
                } else {
                    state = SOLD_OUT;
                }
                return String.format("Dispensing product and change %d", change);
            default:
                var toPay = productPrice - insertedMoneyAmount;
                return String.format("Cannot dispense product - amount %d must be paid", toPay);
        }
    }

    public String cancelPurchase() {
        switch (state) {
            case IN_PAYMENT:
            case AFTER_PAYMENT:
                var toReturn = insertedMoneyAmount;
                insertedMoneyAmount = 0;
                state = IDLE;
                return String.format("Returning %d", toReturn);
            default:
                return "Nothing happens";
        }
    }

    public String refill(int productsBatchAmount) {
        switch (state) {
            case IDLE:
                return "Cannot refill - there are still some products";
            case IN_PAYMENT:
            case AFTER_PAYMENT:
                return "Cannot refill - purchase in progress";
            case SOLD_OUT:
                productsAmount = productsBatchAmount;
                state = IDLE;
                return "Machine refilled";
            default:
                throw new IllegalStateException("Unexpected state");
        }
    }
}
