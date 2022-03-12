package com.chrosciu.debugger.tasks;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.chrosciu.debugger.tasks.Task2.minValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    @Test
    @Disabled
    void shouldCalculateMinimumValueOfGivenValues() {
        assertEquals(1, minValue(List.of(3, 1, 2)));
    }
}
