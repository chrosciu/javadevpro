package com.chrosciu.generics;

public class RawTypes {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("A");
        Box rawBox = stringBox;
        rawBox.setItem(8);
        try {
            String s2 = stringBox.getItem(); //ClassCastException !
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Box rawBox2 = new Box("A");
        Box<String> stringBox2 = rawBox2;
        String s = stringBox2.getItem();
        System.out.println(s);

        Box<Integer> integerBox = rawBox2;
        try {
            Integer i = integerBox.getItem(); //ClassCastException !
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
