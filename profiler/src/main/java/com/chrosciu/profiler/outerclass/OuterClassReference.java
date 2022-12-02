package com.chrosciu.profiler.outerclass;

import java.util.ArrayList;
import java.util.List;

class Outer {
    final Double x;

    Outer(Double x) {
        this.x = x;
    }

    /* static */ class Inner {
        final Double y;

        Inner(Double y) {
            this.y = y;
        }
    }

    public Inner getInner(Double y) {
        return new Inner(y);
    }
}

public class OuterClassReference {
    private List<Outer.Inner> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(new Outer(Math.random()).getInner(Math.random()));
        }
    }

    public static void main(String[] args) {
        OuterClassReference instance = new OuterClassReference();
        instance.populateList();
        System.out.println("After");
    }
}
