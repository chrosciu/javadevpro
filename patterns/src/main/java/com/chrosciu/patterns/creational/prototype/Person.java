package com.chrosciu.patterns.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Person implements Being {
    @Getter
    private final String name;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        name = firstName + " " + lastName;
        this.age = age;
    }

    public Person(Person origin) {
        this.name = origin.name;
        this.age = origin.age;
    }

    @Override
    public Being copy() {
        return new Person(this);
    }
}
