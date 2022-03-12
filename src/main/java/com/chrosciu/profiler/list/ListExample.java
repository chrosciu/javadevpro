package com.chrosciu.profiler.list;

public class ListExample {
    private static void sleep() throws InterruptedException {
        Thread.sleep(30000);
    }

    public static void main(String[] args) throws InterruptedException {
        ListWrapper listWrapper = ListFactory.build(ListType.LINKED);
        System.out.println("1");
        sleep();
        System.out.println("2");
        listWrapper.populate(1000000);
        System.out.println("3");
        sleep();
        System.out.println("4");
        listWrapper.sort();
        System.out.println("5");
        sleep();
        System.out.println("6");
    }
}
