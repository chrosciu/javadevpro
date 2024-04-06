package com.chrosciu.solid.ocp;

import lombok.NonNull;

import java.util.EnumSet;
import java.util.function.Predicate;

public class CarColorsPredicate implements Predicate<Car> {
    private final EnumSet<Color> colors;

    public boolean test(Car car) {
        return this.colors.contains(car.getColor());
    }

    public CarColorsPredicate(@NonNull EnumSet<Color> colors) {
        this.colors = colors;
    }
}
