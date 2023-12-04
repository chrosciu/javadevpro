package com.chrosciu.patterns.behavioral.state;

import lombok.experimental.Delegate;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
class VendingMachine {
    interface State {
        String insertMoney(int moneyAmount);
        String dispenseProduct();
        String cancelPurchase();
        String refill(int productsBatchAmount);
    }

    private int productsAmount = 0;
    private int insertedMoneyAmount = 0;
    private final int productPrice;
    @Delegate
    private State state = new SoldOutState();

    class IdleState implements State {

        @Override
        public String insertMoney(int moneyAmount) {
            insertedMoneyAmount += moneyAmount;
            if (insertedMoneyAmount < productPrice) {
                state = new InPaymentState();
            } else {
                state = new AfterPaymentState();
            }
            return "Money accepted";
        }

        @Override
        public String dispenseProduct() {
            var toPay = productPrice - insertedMoneyAmount;
            return String.format("Cannot dispense product - amount %d must be paid", toPay);
        }

        @Override
        public String cancelPurchase() {
            return "Nothing happens";
        }

        @Override
        public String refill(int productsBatchAmount) {
            return "Cannot refill - there are still some products";
        }
    }

    class InPaymentState implements State {

        @Override
        public String insertMoney(int moneyAmount) {
            insertedMoneyAmount += moneyAmount;
            if (insertedMoneyAmount < productPrice) {
                state = new InPaymentState();
            } else {
                state = new AfterPaymentState();
            }
            return "Money accepted";
        }

        @Override
        public String dispenseProduct() {
            var toPay = productPrice - insertedMoneyAmount;
            return String.format("Cannot dispense product - amount %d must be paid", toPay);
        }

        @Override
        public String cancelPurchase() {
            var toReturn = insertedMoneyAmount;
            insertedMoneyAmount = 0;
            state = new IdleState();
            return String.format("Returning %d", toReturn);
        }

        @Override
        public String refill(int productsBatchAmount) {
            return "Cannot refill - purchase in progress";
        }
    }

    class AfterPaymentState implements State {

        @Override
        public String insertMoney(int moneyAmount) {
            return "Already paid - please request dispensation";
        }

        @Override
        public String dispenseProduct() {
            var change = insertedMoneyAmount - productPrice;
            insertedMoneyAmount = 0;
            productsAmount--;
            if (productsAmount > 0) {
                state = new IdleState();
            } else {
                state = new SoldOutState();
            }
            return String.format("Dispensing product and change %d", change);
        }

        @Override
        public String cancelPurchase() {
            var toReturn = insertedMoneyAmount;
            insertedMoneyAmount = 0;
            state = new IdleState();
            return String.format("Returning %d", toReturn);
        }

        @Override
        public String refill(int productsBatchAmount) {
            return "Cannot refill - purchase in progress";
        }
    }

    class SoldOutState implements State {

        @Override
        public String insertMoney(int moneyAmount) {
            return "Cannot accept money - items sold out";
        }

        @Override
        public String dispenseProduct() {
            return "Items sold out";
        }

        @Override
        public String cancelPurchase() {
            return "Nothing happens";
        }

        @Override
        public String refill(int productsBatchAmount) {
            productsAmount = productsBatchAmount;
            state = new IdleState();
            return "Machine refilled";
        }
    }

}
