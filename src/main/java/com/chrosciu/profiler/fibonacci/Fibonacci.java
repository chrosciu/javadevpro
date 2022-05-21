package com.chrosciu.profiler.fibonacci;

public class Fibonacci {

    private long fib(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long f = fibonacci.fib(30);
        System.out.println("Result: " + f);
    }
}
