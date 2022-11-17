package com.chrosciu;

import java.util.ArrayList;
import java.util.List;

public class InheritanceTraps {
    public static void main(String[] args) {
        Integer i = 7;
        Box<Integer> box = new Box<>(i);

        Number n = i;
        //Box<Number> boxNum = box;

        Number n2 = 2.0;
        //boxNum.setItem(n2);

        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = arrayList;
    }
}
