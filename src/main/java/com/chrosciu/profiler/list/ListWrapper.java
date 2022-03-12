package com.chrosciu.profiler.list;

import java.util.Collections;
import java.util.List;

public abstract class ListWrapper {
    protected final List<Integer> list;

    protected ListWrapper(List<Integer> list) {
        this.list = list;
    }

    public void populate(int size) {
        int num;
        for (int i = 0; i < size; i++) {
            num = (int)(Math.random() * size);
            list.add(num);
        }
    }

    public void sort() {
        Collections.sort(list);
    }
}
