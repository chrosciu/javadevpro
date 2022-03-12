package com.chrosciu.debugger.tasks;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.chrosciu.debugger.tasks.Task1.countPixels;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    @Test
    @Disabled
    void shouldProperlyCountPixels() {
        assertEquals(56, countPixels(7, 8));
    }
}