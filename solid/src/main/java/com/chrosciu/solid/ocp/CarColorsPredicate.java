package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class CarColorsPredicate implements Predicate<Car> {
    private final EnumSet<Color> colors;

    @Override
    public boolean test(Car car) {
        return colors.contains(car.getColor());
    }
}
