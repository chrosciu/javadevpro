package com.chrosciu.debugger.methods;

public class MethodBreakpoint {
    public static void main(String[] args) {
        Example example = ExampleFactory.getExample();
        System.out.println(example.foo(3));
    }
}