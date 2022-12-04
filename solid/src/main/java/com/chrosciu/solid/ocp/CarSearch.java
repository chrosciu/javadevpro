package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    public List<Car> find(Predicate<Car> carPredicate) {
        return repository.getCars().stream().filter(carPredicate).collect(Collectors.toList());
    }

    @Deprecated
    public List<Car> findByName(String name) {
        return find(new CarNamePredicate(name));
    }

}
