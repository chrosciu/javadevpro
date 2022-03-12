package com.chrosciu.debugger.methods;

import java.lang.reflect.InvocationTargetException;

class ExampleFactory {
    static Example getExample() {
        Example example = new ExampleImpl();
        doBoo(example);
        return example;
    }

    private static void doBoo(Object object) {
        try {
            var result = object.getClass().getMethod("boo").invoke(object);
            System.out.println(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
