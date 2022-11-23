package com.chrosciu.patterns.behavioral.memento;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Account {
    private boolean locked = false;
    private BigDecimal balance = ZERO;

    private static final String SEPARATOR = ";";

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
        String state = balance + SEPARATOR + locked;
        return new Memento(state);
    }

    public void restore(Memento memento) {
        String[] values = memento.state.split(SEPARATOR);
        balance = new BigDecimal(values[0]);
        locked = Boolean.parseBoolean(values[1]);
    }

    public class Memento {
        private final String state;

        private Memento(String state) {
            this.state = state;
        }
    }
}
