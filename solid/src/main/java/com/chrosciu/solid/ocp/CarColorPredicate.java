package com.chrosciu.solid.ocp;

import java.util.EnumSet;
import java.util.function.Predicate;

public class CarColorPredicate implements Predicate<Car> {
    public CarColorPredicate(EnumSet<Color> colors) {
    }

    @Override
    public boolean test(Car car) {
        return false;
    }
}
