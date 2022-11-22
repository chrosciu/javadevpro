package com.chrosciu.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;


public class CollectionUtils {
    public static void main(String[] args) {
        Collection<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(-2);

        Collection<String> c2 = List.of("A", "B");

        Collection<Number> c3 = new ArrayList<>();
        c3.add(3);
        c3.add(-4.0f);

        System.out.println(c1.containsAll(c2));

        c3.addAll(c1);
        System.out.println(c3);

        Predicate<Number> testGtZero = new Predicate<Number>() {
            @Override
            public boolean test(Number number) {
                return number.doubleValue() > 0;
            }
        };

        c1.removeIf(testGtZero);
        System.out.println(c1);
    }
}
