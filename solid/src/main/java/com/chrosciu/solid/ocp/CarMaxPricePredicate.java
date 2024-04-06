package com.chrosciu.solid.ocp;

import java.util.function.Predicate;

public class CarMaxPricePredicate implements Predicate<Car> {
    private final int maxPrice;

    public boolean test(Car car) {
        return car.getPrice() <= this.maxPrice;
    }

    public CarMaxPricePredicate(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}
