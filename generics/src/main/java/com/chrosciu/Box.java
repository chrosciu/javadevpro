package com.chrosciu;

public class Box<T> {
    private T item;

    public Box(T t) {
        this.item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        int i = 7;
        Box<Integer> box = new Box<>(i);

        System.out.println(box.getItem());

        box.setItem(3);
        System.out.println(box.getItem());
    }
}




