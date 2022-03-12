package com.chrosciu.debugger.methods;

class ExampleImpl implements Example {
    @Override
    public int foo(int x) {
        var result = x + 1;
        System.out.println(result);
        return result;
    }

    @Override
    public int boo() {
        int x = 7;
        x++;
        System.out.println(x);
        return x;
    }
}
