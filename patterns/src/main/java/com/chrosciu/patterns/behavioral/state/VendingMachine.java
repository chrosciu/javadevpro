package com.chrosciu.patterns.behavioral.state;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class VendingMachine {
    private final int productPrice;
    private int productsAmount = 0;
    private int insertedMoneyAmount = 0;

    public String insertMoney(int moneyAmount) {
        if (productsAmount <= 0) {
            return "Cannot accept money - items sold out";
        } else if (insertedMoneyAmount > productPrice) {
            return "Already paid - please request dispensation";
        } else {
            insertedMoneyAmount += moneyAmount;
            return "Money accepted";
        }
    }

    public String dispenseProduct() {
        if (productsAmount <= 0) {
            return "Items sold out";
        }
        if (insertedMoneyAmount >= productPrice) {
            var change = insertedMoneyAmount - productPrice;
            insertedMoneyAmount = 0;
            productsAmount--;
            return String.format("Dispensing product and change %d", change);
        } else {
            var toPay = productPrice - insertedMoneyAmount;
            return String.format("Cannot dispense product - amount %d must be paid", toPay);
        }
    }

    public String cancelPurchase() {
        if (insertedMoneyAmount > 0) {
            var toReturn = insertedMoneyAmount;
            insertedMoneyAmount = 0;
            return String.format("Returning %d", toReturn);
        } else {
            return "Nothing happens";
        }
    }

    public String refill(int productsBatchAmount) {
        if (insertedMoneyAmount > 0) {
            return "Cannot refill - purchase in progress";
        } else if (productsAmount > 0) {
            return "Cannot refill - there are still some products";
        } else {
            productsAmount = productsBatchAmount;
            return "Machine refilled";
        }
    }

}
