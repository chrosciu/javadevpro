package com.chrosciu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Part08PairEqualsPairTest {
    @Test
    void twoPairsShouldBeEqualIfTheirFieldsAreEqual() {
        Pair<Integer, String> pair1 = new Pair<>(1, "A");
        Pair<Number, CharSequence> pair2 = new Pair<>(1, "A");

        assertThat(pair1.equals(pair2)).isTrue();
        assertThat(pair2.equals(pair1)).isTrue();
    }

    @Test
    void twoPairsShouldNotBeEqualIfTheirFieldsAreDifferent() {
        Pair<Integer, String> pair1 = new Pair<>(1, "A");
        Pair<Number, CharSequence> pair2 = new Pair<>(1, "B");
        Pair<Number, CharSequence> pair3 = new Pair<>(2, "A");

        assertThat(pair1.equals(pair2)).isFalse();
        assertThat(pair2.equals(pair1)).isFalse();
        assertThat(pair1.equals(pair3)).isFalse();
        assertThat(pair3.equals(pair1)).isFalse();
    }
}
