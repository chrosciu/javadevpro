package com.chrosciu.cleancode.ioc.highlevel;

import com.chrosciu.cleancode.ioc.lowlevel.LowInt;
import com.chrosciu.cleancode.ioc.lowlevel.LowString;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class High {
    private final IntOperation intOp;
    private final StringOperation stringOp;
    public static void main(String[] args) {
        High high = new High(new LowInt(), new LowString());
        System.out.println(high.add(3, 4));
        System.out.println(high.toUpper("Marcin"));
    }

    private int add(int a, int b) {
        return intOp.add(a, b);
    }

    private String toUpper(String s) {
        return stringOp.toUpper(s);
    }
}
