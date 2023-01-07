package com.chrosciu.patterns.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

public class IteratorsTest {
    private final List<Integer> list = List.of(2, 3, 1);

    @Test
    void regularIteratorTest() {
        Iterator<Integer> iterator = Iterators.regularIterator(list);
        //Assertions.assertThat(iterator).containsExactly(2, 3, 1);
    }

    @Test
    void reverseIteratorTest() {
        Iterator<Integer> iterator = Iterators.reverseIterator(list);
        //Assertions.assertThat(iterator).containsExactly(1, 3, 2);
    }
}
