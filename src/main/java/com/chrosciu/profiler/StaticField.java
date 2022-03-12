package com.chrosciu.profiler;

import java.util.ArrayList;
import java.util.List;

public class StaticField {
    private /*static*/ List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        sleep();
        System.out.println("2");
        new StaticField().populateList();
        System.out.println("3");
        sleep();
        System.out.println("4");

    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(30000);
    }
}
