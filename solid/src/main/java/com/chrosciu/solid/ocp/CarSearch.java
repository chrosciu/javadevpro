package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    @Deprecated
    public List<Car> findByName(String name) {
        CarNameCondition carNameCondition = new CarNameCondition(name);
        return repository.getCars().stream().filter(carNameCondition).collect(Collectors.toList());
    }

    public List<Car> findByMaxPrice(int maxPrice) {
        return repository.getCars().stream().filter(c -> c.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    public List<Car> findBy(Predicate<Car> condition) {
        return repository.getCars().stream().filter(condition).collect(Collectors.toList());
    }

    /*


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

     */
}
