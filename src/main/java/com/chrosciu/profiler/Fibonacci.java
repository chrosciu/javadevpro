package com.chrosciu.profiler;

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

    private static void sleep() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("1");
        //sleep();
        System.out.println("2");
        long f = fibonacci.fib(20);
        System.out.println("Result: " + f);
        System.out.println("3");
        //sleep();
        System.out.println("4");
    }
}
