package com.chrosciu.solid.ocp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class CarNamePredicate implements Predicate<Car> {
    @NonNull
    private final String name;

    @Override
    public boolean test(Car car) {
        return name.equals(car.getName());
    }
}
