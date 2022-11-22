package com.chrosciu.generics;

import java.util.List;

public class InferenceTraps {
    public static void main(String[] args) {
        List<String> list = List.of();
        String s1 = list.get(0);
        System.out.println(s1);

        //String s2 = List.of().get(0); // will not compile !

        String s3 = List.<String>of().get(0);

        var l = List.of();
    }
}
