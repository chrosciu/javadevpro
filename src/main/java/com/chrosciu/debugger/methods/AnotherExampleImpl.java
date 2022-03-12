package com.chrosciu.debugger.methods;

class AnotherExampleImpl implements Example {
    @Override
    public int foo(int x) {
        return x - 1;
    }

    @Override
    public int boo() {
        return 0;
    }
}
