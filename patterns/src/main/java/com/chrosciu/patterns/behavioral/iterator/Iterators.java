package com.chrosciu.patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static <E> Iterator<E> regularIterator(List<E> list) {
        return list.iterator();
    }

    public static <E> Iterator<E> reverseIterator(List<E> list) {
        return new Iterator<E>() {
            private int currentElemIndex = list.size() - 1;

            @Override
            public boolean hasNext() {
                return currentElemIndex >= 0;
            }

            @Override
            public E next() {
                return list.get(currentElemIndex--);
            }
        };
    }
}
