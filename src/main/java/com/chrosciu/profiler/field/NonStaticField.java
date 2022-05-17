package com.chrosciu.profiler.field;

import java.util.ArrayList;
import java.util.List;

public class NonStaticField {
    private List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NonStaticField().populateList();
        System.out.println("After");
    }
}
