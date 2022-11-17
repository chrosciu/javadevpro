package com.chrosciu;

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



    public static void main(String[] args) {
        Box<Number> box1 = new Box<>(1);
        System.out.println(getBoxIntValue(box1));

        Box<Integer> box2 = new Box<>(2);
        System.out.println(getBoxIntValue(box2));

        setBoxIntValue(box2, 3);
        setBoxIntValue(box1, 3);

        System.out.println(getBoxHashCode(box1));
        System.out.println(getBoxHashCode(box2));
    }


}
