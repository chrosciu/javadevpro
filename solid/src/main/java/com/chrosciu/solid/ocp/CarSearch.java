package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    public List<Car> findByName(String name) {
        return repository.getCars().stream().filter(c -> name.equals(c.getName())).collect(Collectors.toList());
    }

    public List<Car> findByMaxPrice(int maxPrice) {
        //TODO: Implement
        return null;
    }

    public List<Car> findByColors(EnumSet<Color> colors) {
        //TODO: Implement
        return null;
    }

    public List<Car> findByMaxPriceAndMaxFuelUsage(int maxPrice, double maxFuelUsage) {
        //TODO: Implement
        return null;
    }

    public List<Car> findByMaxPriceOrMaxFuelUsage(int maxPrice, double maxFuelUsage) {
        //TODO: Implement
        return null;
    }
}
