package com.chrosciu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Part02PairUtilsSwapBasicTest {
    @Test
    void shouldSwapPairValues() {
        Pair<Integer, String> pair = new Pair<>(1, "A");

        Pair<String, Integer> swapped = PairUtils.swap(pair);

        assertThat(swapped.getFirst()).isEqualTo("A");
        assertThat(swapped.getSecond()).isEqualTo(1);
    }
}
