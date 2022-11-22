package com.chrosciu.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Part01PairBasicTest {
    @Test
    void shouldCreatePairWithGivenValues() {
        Pair<Integer, String> pair = new Pair<>(1, "A");

        assertThat(pair.getFirst()).isEqualTo(1);
        assertThat(pair.getSecond()).isEqualTo("A");
    }
}
