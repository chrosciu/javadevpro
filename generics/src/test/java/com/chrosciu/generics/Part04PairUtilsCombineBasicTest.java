package com.chrosciu.generics;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

class Part04PairUtilsCombineBasicTest {
    @Test
    void shouldCombinePairItems() {
        Pair<Integer, String> pair = new Pair<>(1, "A");
        BiFunction<Integer, String, String> combiner = (i, s) -> i + s;

        String combined = PairUtils.combine(pair, combiner);

        assertThat(combined).isEqualTo("1A");
    }
}
