package com.chrosciu;

import java.util.Map;
import java.util.function.BiFunction;

class PairUtils {
    public static <T, U> Pair<U, T> swap(Pair<? extends T, ? extends U> pair) {
        return new Pair<>(pair.getSecond(), pair.getFirst());
    }

    public static <T, U> boolean addToMap(Pair<? extends T, ? extends U> pair, Map<? super T, ? super U> map) {
        if (map.containsKey(pair.getFirst())) {
            return false;
        } else {
            map.put(pair.getFirst(), pair.getSecond());
            return true;
        }
    }

    public static <T, U, V> V combine(Pair<? extends T, ? extends U> pair, BiFunction<? super T, ? super U, ? extends V> combiner) {
        return combiner.apply(pair.getFirst(), pair.getSecond());
    }
}
