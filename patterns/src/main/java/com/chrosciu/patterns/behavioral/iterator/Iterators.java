package com.chrosciu.patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static <E> Iterator<E> regularIterator(List<E> list) {
        return list.iterator();
    }

    public static <E> Iterator<E> reverseIterator(List<E> list) {
        return null;
    }
}
