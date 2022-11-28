package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class CarMaxFuelUsagePredicate implements Predicate<Car> {
    private final double maxFuelUsage;

    @Override
    public boolean test(Car car) {
        return car.getFuelUsage() <= maxFuelUsage;
    }
}
