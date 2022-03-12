package com.chrosciu.debugger.fields;

public class FieldBreakpoint {
    private int var = 7;

    public static void main(String[] args) {
        FieldBreakpoint fieldBreakpoint = new FieldBreakpoint();
        Manipulator.manipulate(fieldBreakpoint);
        Manipulator.manipulate(fieldBreakpoint);
        System.out.println(fieldBreakpoint.var);
    }

    void foo() {
        var += 1;
    }

    void boo() {
        var -= 2;
    }

    public int getVar() {
        return var;
    }
}
