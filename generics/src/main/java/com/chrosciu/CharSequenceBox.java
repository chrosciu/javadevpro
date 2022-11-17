package com.chrosciu;


public class CharSequenceBox<T extends CharSequence> {
    final T item;

    public CharSequenceBox(T item) {
        this.item = item;
    }

    public char charAt(int index) {
        return item.charAt(index);
    }

    public static void main(String[] args) {
        CharSequenceBox<String> box = new CharSequenceBox<>("ABC");
        System.out.println(box.charAt(1));
    }
}
