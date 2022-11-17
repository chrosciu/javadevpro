package com.chrosciu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Part05PairUtilsSwapExtendedTest {
    @Test
    void shouldSwapPairValues() {
        Pair<Integer, String> pair = new Pair<>(1, "A");

        Pair<CharSequence, Number> swapped = PairUtils.swap(pair);

        assertThat(swapped.getFirst()).isEqualTo("A");
        assertThat(swapped.getSecond()).isEqualTo(1);
    }
}
