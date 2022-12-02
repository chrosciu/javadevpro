package com.chrosciu.cleancode.coupling;

interface Nameable {
    String getName();
}

class Person implements Nameable {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Display {
    public void displayName(Nameable nameable) {
        System.out.println(nameable.getName());
    }
}

public class HighCoupling {
    public static void main(String[] args) {
        Person person = new Person("Marcin");
        Display display = new Display();
        display.displayName(person);
    }
}
