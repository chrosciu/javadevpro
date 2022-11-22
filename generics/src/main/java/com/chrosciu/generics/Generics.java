package com.chrosciu.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String s = "hello";
        list.add(s);
        String s2 = list.get(0);
        Integer i = 1;
        //list.add(i);
        String s3 = list.get(1);
    }
}
