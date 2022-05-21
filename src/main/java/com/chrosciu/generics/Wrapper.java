package com.chrosciu.generics;

import java.util.ArrayList;
import java.util.List;

public class Wrapper<T> {
    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Wrapper<Integer> wrapper = new Wrapper<>(5);
        wrapper.set(7);

        Wrapper<Integer> wrapper1 = new Wrapper<>(5);
    }
}

class Foo {
    public void foo() {

    }
}

class Bar extends Foo {

}

class NaturalNumber<T extends Foo> {
    private T n;

    public void foo() {
        n.foo();
    }

    public static void main(String[] args) {
        NaturalNumber<Foo> n = new NaturalNumber<>();
        NaturalNumber<Bar> n2 = new NaturalNumber<>();
        //NaturalNumber<String> n = new NaturalNumber<>();
    }
}

class GenericInheritance {
    public static void main(String[] args) {
        Wrapper<Integer> wrapper = new Wrapper<>(5);
        Wrapper<Number> numberWrapper = wrapper;
        Number n = 2.0; //Double
        numberWrapper.set(n);
    }
}

class WrapperUtil {
    static <U> U getValue(Wrapper<U> wrapper) {
        return wrapper.get();
    }

    public static void main(String[] args) {
        Wrapper<Integer> wrapper = new Wrapper<>(5);
        Integer i = WrapperUtil.getValue(wrapper);
        System.out.println(i);
    }
}

class ListUtil {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void addNumber(List<? super Integer> list, Integer i) {
            list.add(i);
    }

    public static int sumHashCodes(List<?> list) {
        int sum = 0;
        for (Object elem: list) {
            sum += elem.hashCode();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Number> numberList = List.of(1, 2.0);
        System.out.println(sumOfList(numberList));

        List<Integer> integerList = List.of(1, 2);
        System.out.println(sumOfList(integerList));

        addNumber(integerList, 3);
        addNumber(numberList, 3);

        List list1;

        List<Object> list2;

        List<?> list3 = new ArrayList<>();

        Object o = list3.get(0);
        list3.add(null);
    }
}
