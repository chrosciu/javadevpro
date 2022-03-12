package com.chrosciu.debugger.basic;

import java.io.IOException;

public class BasicDebug {

    public static void main(String[] args) throws IOException {
        System.out.println("Program started, waiting for input:");
        while (true) {
            int read = System.in.read();
            //System.out.println("Input " + read);
            if (filter(read)) {
                process(read);
            }
        }
    }

    private static boolean filter(int read) {
        return read != '\n';
    }

    private static void process(int arg) {
        if (Math.abs(arg) > 1 && arg % 2 == 0) {
            System.out.println("!");
        }
    }
}