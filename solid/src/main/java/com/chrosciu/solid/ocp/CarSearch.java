package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    @Deprecated
    public List<Car> findByName(String name) {
        return findBy(new CarNamePredicate(name));
    }

    @Deprecated
    public List<Car> findByMaxPrice(int maxPrice) {
        return findBy(new CarMaxPricePredicate(maxPrice));
    }

    public List<Car> findBy(Predicate<Car> carPredicate) {
        return repository.getCars().stream().filter(carPredicate).collect(Collectors.toList());
    }
}
