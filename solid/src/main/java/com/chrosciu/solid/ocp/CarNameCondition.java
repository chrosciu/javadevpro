package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class CarNameCondition implements Predicate<Car> {
    private final String name;

    @Override
    public boolean test(Car car) {
        return name.equals(car.getName());
    }
}
