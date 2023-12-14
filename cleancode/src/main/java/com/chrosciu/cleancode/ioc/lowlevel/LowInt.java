package com.chrosciu.cleancode.ioc.lowlevel;

import com.chrosciu.cleancode.ioc.highlevel.IntOperation;

public class LowInt implements IntOperation {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
