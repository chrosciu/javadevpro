package com.chrosciu;

public class SimpleBoxUtils {
    public static <U> Box<U> copyBox(Box<U> box) {
        return new Box<>(box.getItem());
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(7);
        Box<Integer> copied = copyBox(box);
        System.out.println(copied.getItem());
    }
}
