package com.chrosciu.profiler;

import java.util.ArrayList;
import java.util.List;

public class ConstantReallocation {
    private List<Double> list;

    public void populateList() {
        list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConstantReallocation instance = new ConstantReallocation();
        System.out.println("start");
        sleep();
        for (;;) {
            System.out.println("allocate");
            instance.populateList();
            System.out.println("sleep");
            shortSleep();
        }
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(30000);
    }

    private static void shortSleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
