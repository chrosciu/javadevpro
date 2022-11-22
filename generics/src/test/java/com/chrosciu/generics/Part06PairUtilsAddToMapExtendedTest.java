package com.chrosciu.generics;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Part06PairUtilsAddToMapExtendedTest {
    @Test
    void shouldAddPairToMapIfKeyIsNotPresent() {
        Map<Number, CharSequence> map = new HashMap<>();
        map.put(1, "A");
        Pair<Integer, String> pair = new Pair<>(2, "B");

        boolean added = PairUtils.addToMap(pair, map);

        assertThat(added).isTrue();
        assertThat(map).containsEntry(2, "B");
    }
}
