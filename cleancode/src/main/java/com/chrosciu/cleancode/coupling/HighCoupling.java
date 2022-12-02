package com.chrosciu.cleancode.coupling;

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Display {
    public void displayName(Person person) {
        System.out.println(person.getName());
    }
}

public class HighCoupling {
    public static void main(String[] args) {
        Person person = new Person("Marcin");
        Display display = new Display();
        display.displayName(person);
    }
}
