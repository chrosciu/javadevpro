package com.chrosciu.cleancode.cohesion;

class Foo {
    private int foo = 3;

    public void doOtherStuff() {
        if (foo < 10) {
            foo = foo * 2;
            System.out.println(foo);
        }
    }
}

class Bar {
    private int bar = 7;

    public void doStuff() {
        if (bar > 0) {
            bar = bar - 1;
            System.out.println(bar);
        }
    }
}

public class LowCohesion {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.doStuff();
        Foo foo = new Foo();
        foo.doOtherStuff();
    }
}
