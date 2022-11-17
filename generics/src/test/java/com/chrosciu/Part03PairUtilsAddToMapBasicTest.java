package com.chrosciu;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Part03PairUtilsAddToMapBasicTest {
    @Test
    void shouldAddPairToMapIfKeyIsNotPresent() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        Pair<Integer, String> pair = new Pair<>(2, "B");

        boolean added = PairUtils.addToMap(pair, map);

        assertThat(added).isTrue();
        assertThat(map).containsEntry(2, "B");
    }

    @Test
    void shouldNotAddPairToMapIfKeyIsPresent() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        Pair<Integer, String> pair = new Pair<>(1, "B");

        boolean added = PairUtils.addToMap(pair, map);

        assertThat(added).isFalse();
        assertThat(map).doesNotContainEntry(1, "B");
    }
}
