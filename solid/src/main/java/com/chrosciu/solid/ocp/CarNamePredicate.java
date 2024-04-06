package com.chrosciu.solid.ocp;

import lombok.NonNull;

import java.util.function.Predicate;

public class CarNamePredicate implements Predicate<Car> {
    private final String name;

    public boolean test(Car car) {
        return this.name.equals(car.getName());
    }

    public CarNamePredicate(@NonNull String name) {
        this.name = name;
    }
}
