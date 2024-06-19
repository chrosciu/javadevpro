package com.chrosciu.solid.ocp;

import java.util.function.Predicate;

public class CarNamePredicate implements Predicate<Car> {
    public CarNamePredicate(String carName) {
    }

    @Override
    public boolean test(Car car) {
        return false;
    }
}
