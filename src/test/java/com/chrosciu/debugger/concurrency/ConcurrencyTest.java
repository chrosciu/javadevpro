package com.chrosciu.debugger.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrencyTest {
    @Test
    //@Disabled
    void shouldNotHaveDuplicatedElements() throws InterruptedException {
        assertEquals(1, Concurrency.work().size());
    }
}
