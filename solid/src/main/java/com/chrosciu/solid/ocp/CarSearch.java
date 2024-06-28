package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    public List<Car> findBy(Predicate<Car> filter) {
        return repository.getCars().stream().filter(filter).collect(Collectors.toList());
    }

    @Deprecated
    public List<Car> findByName(String name) {
        return findBy(new CarNameFilter(name));
    }

    @Deprecated
    public List<Car> findByMaxPrice(int maxPrice) {
        return findBy(new CarMaxPriceFilter(maxPrice));
    }
}
