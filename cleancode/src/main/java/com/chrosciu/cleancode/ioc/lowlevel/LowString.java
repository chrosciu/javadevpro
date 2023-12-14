package com.chrosciu.cleancode.ioc.lowlevel;

import com.chrosciu.cleancode.ioc.highlevel.StringOperation;

public class LowString implements StringOperation {
    @Override
    public String toUpper(String s) {
        return s.toUpperCase();
    }
}
