package com.chrosciu.cleancode.cohesion;

class FooBar {
    private int foo = 3;
    private int bar = 7;

    public void doStuff() {
        if (bar > 0) {
            bar = bar - 1;
            System.out.println(bar);
        }
    }

    public void doOtherStuff() {
        if (foo < 10) {
            foo = foo * 2;
            System.out.println(foo);
        }
    }
}

public class LowCohesion {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        fooBar.doStuff();
        fooBar.doOtherStuff();
    }
}
