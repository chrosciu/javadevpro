package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
class CarNamePredicate implements Predicate<Car> {
    private final String name;

    @Override
    public boolean test(Car car) {
        return name.equals(car.getName());
    }
}
