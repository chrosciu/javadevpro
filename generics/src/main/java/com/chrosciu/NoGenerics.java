package com.chrosciu;

import java.util.ArrayList;
import java.util.List;

public class NoGenerics {
    public static void main(String[] args) {
        List list = new ArrayList();
        String s = "hello";
        list.add(s);
        String s2 = (String)(list.get(0));
        Integer i = 1;
        list.add(i);
        String s3 = (String)(list.get(1));
    }
}
