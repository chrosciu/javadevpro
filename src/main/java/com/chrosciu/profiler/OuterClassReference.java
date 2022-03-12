package com.chrosciu.profiler;

import java.util.ArrayList;
import java.util.List;

class Outer {
    final Double x;

    Outer(Double x) {
        this.x = x;
    }
}

public class OuterClassReference {

    private List<Outer> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(new Outer(Math.random()));
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OuterClassReference instance = new OuterClassReference();
        System.out.println("1");
        sleep();
        System.out.println("2");
        instance.populateList();
        System.out.println("3");
        sleep();
        System.out.println("4");
    }
}
