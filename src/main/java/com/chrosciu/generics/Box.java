package com.chrosciu.generics;

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

        Box<Number> box1 = new Box<>(1);
        System.out.println(BoxUtils.getBoxIntValue(box1));

        Box<Integer> box2 = new Box<>(2);
        System.out.println(BoxUtils.getBoxIntValue(box2));

        BoxUtils.setBoxIntValue(box2, 3);
        BoxUtils.setBoxIntValue(box1, 3);


    }
}

class BoxUtils {
    public static <T extends Integer> int getBoxValue(Box<T> box) {
        return box.getItem().intValue();
    }

    public static int getBoxIntValue(Box<? extends Number> box) {
        return box.getItem().intValue();
    }

    public static void setBoxIntValue(Box<? super Integer> box, Integer val) {
        box.setItem(val);
    }

    public static int getBoxHashCode(Box<?> box) {
        return box.getItem().hashCode();
    }

    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static <E> void append(List<E> list, Class<E> clazz) throws Exception {
        E elem = clazz.newInstance();  // compile-time error
        list.add(elem);
    }

//we can pass here List<Number>, List<Integer>, List<Double>, etc.
}




