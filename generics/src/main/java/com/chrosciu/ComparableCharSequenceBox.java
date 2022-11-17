package com.chrosciu;


public class ComparableCharSequenceBox<T extends CharSequence & Comparable<T>> {
    private final T item;

    public ComparableCharSequenceBox(T item) {
        this.item = item;
    }

    public char charAt(int index) {
        return item.charAt(index);
    }

    public int compareTo(T other) {
        return item.compareTo(other);
    }

    public static void main(String[] args) {
        ComparableCharSequenceBox<String> box = new ComparableCharSequenceBox<>("ABC");
        System.out.println(box.charAt(1));
        System.out.println(box.compareTo("A"));
    }
}
