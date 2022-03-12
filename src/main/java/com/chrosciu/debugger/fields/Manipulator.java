package com.chrosciu.debugger.fields;

import java.util.Random;

class Manipulator {
    static void manipulate(FieldBreakpoint fieldBreakpoint) {
        if (new Random().nextInt(10) > 5) {
            fieldBreakpoint.foo();
        } else {
            fieldBreakpoint.boo();
        }
        if (fieldBreakpoint.getVar() > 5) {
            System.out.println("More than 5");
        }
    }
}
