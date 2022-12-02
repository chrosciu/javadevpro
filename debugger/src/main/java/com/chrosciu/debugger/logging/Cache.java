package com.chrosciu.debugger.logging;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    static Map<Integer, Cache> instances = new HashMap<>();
    final int i;

    public Cache(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; ++i) {
            System.out.println(getInstance(i));
        }
        for (int i = 0; i <= 10; ++i) {
            System.out.println(getInstance(i));
        }
    }

    static Cache getInstance(int i) {
        if (null == instances.get(i)) {
            instances.put(i, new Cache(i));
        }
        return instances.get(i);
    }

    @Override
    public String toString() {
        return String.format("Cache: [i: %d]", i);
    }
}
