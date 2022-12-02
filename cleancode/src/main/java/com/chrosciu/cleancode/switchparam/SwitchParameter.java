package com.chrosciu.cleancode.switchparam;

class Arithmetic {
    public int execute(int a, int b, int c) {
        if (c > 0) {
            return a + b;
        } else {
            return a - b;
        }
    }
}

public class SwitchParameter {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        System.out.println(arithmetic.execute(3, 4, 1));
        System.out.println(arithmetic.execute(3, 4, -1));
    }
}
