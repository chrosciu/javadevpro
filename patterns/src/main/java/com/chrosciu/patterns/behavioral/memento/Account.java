package com.chrosciu.patterns.behavioral.memento;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Account {
    private boolean locked = false;
    private BigDecimal balance = ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void deposit(BigDecimal value) {
        balance = balance.add(value);
    }

    public void lock() {
        locked = true;
    }

    public Memento save() {
        //TODO: Implement
        return null;
    }

    public void restore(Memento memento) {
        //TODO: Implement
    }

    public class Memento {
        //TODO: Implement
    }
}
