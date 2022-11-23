package com.chrosciu.patterns.behavioral.memento;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    private final Account account = new Account();

    @Test
    public void newAccountShouldHaveZeroBalance() {
        assertThat(account.getBalance()).isZero();
    }

    @Test
    public void newAccountShouldNotBeLocked() {
        assertThat(account.isLocked()).isFalse();
    }

    @Test
    public void shouldSumUpBalance() {
        account.deposit(BigDecimal.valueOf(20));
        account.deposit(BigDecimal.valueOf(-10));
        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.valueOf(10));
    }

    @Test
    public void shouldAllowLocking() {
        account.lock();
        assertThat(account.isLocked()).isTrue();
    }

    @Test
    public void shouldRestoreStateFromSavedMemento() {
        account.deposit(BigDecimal.valueOf(20));
        Account.Memento memento = account.save();
        account.deposit(BigDecimal.valueOf(-10));
        account.lock();

        account.restore(memento);

        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(20));
        assertThat(account.isLocked()).isFalse();
    }



}
