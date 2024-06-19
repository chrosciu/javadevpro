package com.chrosciu.solid.ocp;

import java.util.function.Predicate;

public class CarNamePredicate implements Predicate<Car> {
    private String name;

    public CarNamePredicate(String name) {
        this.name = name;
    }

    @Override
    public boolean test(Car car) {
        return name.equals(car.getName());
    }
}
