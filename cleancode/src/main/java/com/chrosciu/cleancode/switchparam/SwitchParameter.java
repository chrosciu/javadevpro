package com.chrosciu.cleancode.switchparam;

class Arithmetic {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}

public class SwitchParameter {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        System.out.println(arithmetic.add(3, 4));
        System.out.println(arithmetic.subtract(3, 4));
    }
}
