package com.chrosciu.debugger.tasks;

import org.junit.jupiter.api.Test;

import static com.chrosciu.debugger.tasks.Task3.findSubstringIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {
    @Test
    //@Disabled
    void shouldFindIndexOfSubstring() {
        assertEquals(2, findSubstringIndex("abc", "ababcbc"));
        assertEquals(-1, findSubstringIndex("abcd", "ababcbc"));
        assertEquals(2, findSubstringIndex("abc", "ababc"));
    }
}