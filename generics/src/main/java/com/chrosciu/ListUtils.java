package com.chrosciu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    public static double sumOfListAsDouble(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public static void printList(List<?> list) {
        System.out.println("=== Begin of list ===");
        for (Object elem : list) {
            System.out.print(elem.getClass().getName() + "@" + Integer.toHexString(elem.hashCode()) + " -> " + elem + " ");
        }
        System.out.println();
        System.out.println("=== End of list ===");
    }

    public static void addIntToList(List<? super Integer> list, Integer... elems) {
        List<Integer> toAdd = Arrays.asList(elems);
        list.addAll(toAdd);
    }

//    public static <E> void append(List<? super E> list) {
//        E elem = new E();
//        list.add(elem);
//    }

    public static <E> void appendWithClass(List<? super E> list, Class<E> clazz) throws Exception {
        E elem = clazz.getDeclaredConstructor().newInstance();
        list.add(elem);
    }

    public static void main(String[] args) throws Exception {
        List<Number> numList = List.of(1, 2.0f);
        List<Integer> intList = List.of(1, 2);
        List<Float> floatList = List.of(1.0f, 2.0f);
        List<Object> objectList = new ArrayList<>();

        System.out.println(sumOfListAsDouble(numList));
        System.out.println(sumOfListAsDouble(intList));
        System.out.println(sumOfListAsDouble(floatList));
        //System.out.println(sumOfListAsDouble(objectList));

        printList(intList);
        printList(floatList);

        addIntToList(intList, 3, 4);
        addIntToList(objectList, 3, 4);
        //addIntToList(floatList, 3, 4);

        appendWithClass(objectList, String.class);

        printList(objectList);
    }
}
