package com.chrosciu.generics;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

class Part07PairUtilsCombineExtendedTest {
    @Test
    void shouldCombinePairItems() {
        Pair<Integer, String> pair = new Pair<>(1, "A");
        BiFunction<Number, String, CharSequence> combiner = (i, s) -> i + s;

        CharSequence combined = PairUtils.combine(pair, combiner);

        assertThat(combined).isEqualTo("1A");
    }
}
