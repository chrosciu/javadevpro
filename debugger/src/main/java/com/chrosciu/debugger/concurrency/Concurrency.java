package com.chrosciu.debugger.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Concurrency {
    static List<Integer> work() throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Thread thread = new Thread(() -> addIfAbsent(list, 17));
        thread.start();
        addIfAbsent(list, 17);
        thread.join();
        return list;
    }

    private static void addIfAbsent(List<Integer> list, int x) {
        synchronized (Concurrency.class) {
            if (!list.contains(x)) {
                list.add(x);
            }
        }
    }
}
