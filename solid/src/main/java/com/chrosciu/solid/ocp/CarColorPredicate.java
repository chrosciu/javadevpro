package com.chrosciu.solid.ocp;

import java.util.EnumSet;
import java.util.function.Predicate;

public class CarColorPredicate implements Predicate<Car> {
    private final EnumSet<Color> colors;

    public CarColorPredicate(EnumSet<Color> colors) {
        this.colors = colors;
    }

    @Override
    public boolean test(Car car) {
        return colors.contains(car.getColor());
    }
}
