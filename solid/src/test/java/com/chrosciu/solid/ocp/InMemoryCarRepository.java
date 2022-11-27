package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InMemoryCarRepository implements CarRepository {
    private final List<Car> cars;

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
