package com.chrosciu.patterns.behavioral.memento;

import lombok.Getter;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@Getter
public class Account {
    private boolean locked = false;
    private BigDecimal balance = ZERO;

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
