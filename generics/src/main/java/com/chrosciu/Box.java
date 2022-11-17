package com.chrosciu;

import java.util.ArrayList;
import java.util.List;

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
        Integer i = 7;
        Number n = i;

        Box<Integer> box = new Box<>(7);

        //Box<Number> boxNum = box;

        Number n2 = 2.0;
        //boxNum.setItem(n2);

        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = arrayList;




    }
}




