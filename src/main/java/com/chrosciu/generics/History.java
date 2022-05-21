package com.chrosciu.generics;

import java.util.ArrayList;
import java.util.List;

public class History {

    static class Arrays {
        public static void main(String[] args) {
            Integer[] ints = new Integer[2];
            ints[0] = 1;
            //ints[1] = "A";

            Object[] objs = ints;
            objs[1] = "A";
        }
     }

     static class RawList {
         public static void main(String[] args) {
             List list = new ArrayList();
             Integer i = 1;
             //list.add(i);
             list.add("A");

             Integer i2 = (Integer) list.get(0);
         }
     }

     static class NaiveIntList {
         public static void main(String[] args) {
             class IntList {
                 void add(Integer i) {
                 }

                 Integer get(int index) {
                     return 0;
                 }
             }
         }
     }

     static class GenericList {
         public static void main(String[] args) {
             List<Integer> list = new ArrayList<Integer>();
             Integer i = 1;
             list.add(i);
             //list.add("A");

             Integer i2 = list.get(0);
         }
     }

     static class OldNewList {
         public static void main(String[] args) {
             List old = new ArrayList();
             List<Integer> nev = new ArrayList<>();

             old = nev;
             nev = old;
         }
     }

}
