package com.chrosciu;

import java.util.ArrayList;
import java.util.List;

public class InheritanceTraps {
    public static void main(String[] args) {
        Integer i = 7;
        Box<Integer> boxInt = new Box<>(i);

        Number n = i;
        //Box<Number> boxNum = boxInt;

        Double d = 2.0;
        Number doubleNum = d;
        //boxNum.setItem(doubleNum);

        Integer i2 = boxInt.getItem(); //ClassCastException gdyby kod powyzej sie skompilowal

        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = arrayList;
    }
}
