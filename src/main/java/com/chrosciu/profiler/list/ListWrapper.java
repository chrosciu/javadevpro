package com.chrosciu.profiler.list;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class ListWrapper {
    protected final List<Integer> list;
    private final Random random = new Random();

    protected ListWrapper(List<Integer> list) {
        this.list = list;
    }

    public void populate(int size, boolean reversed) {
        for (int i = 0; i < size; i++) {
            var num = random.nextInt(size);
            if (reversed) {
                list.add(0, num);
            } else {
                list.add(num);
            }
        }
    }

    public void sort() {
        Collections.sort(list);
    }
}
