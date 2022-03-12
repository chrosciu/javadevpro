package com.chrosciu.debugger.exceptions;

import java.util.Random;

public class ExceptionBreakpoint {
    public static void main(String[] args) {
        try {
            doSomethingDangerous();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int a = 1/0;
    }

    private static void doSomethingDangerous() {
        int i = new Random().nextInt(10);
        Object o = (i >= 0) ? null : new Object();
        System.out.println(o.hashCode());
    }
}
