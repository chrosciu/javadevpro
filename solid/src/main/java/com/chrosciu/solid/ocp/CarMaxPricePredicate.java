package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public class CarMaxPricePredicate implements Predicate<Car> {
    private final int maxPrice;

    @Override
    public boolean test(Car car) {
        return car.getPrice() <= maxPrice;
    }
}
