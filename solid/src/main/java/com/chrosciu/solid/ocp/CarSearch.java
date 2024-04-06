package com.chrosciu.solid.ocp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

    @Deprecated
    public List<Car> findByName(@NonNull String name) {
        return repository.getCars().stream().filter(new CarNamePredicate(name)).collect(Collectors.toList());
    }

    public List<Car> findBy(@NonNull Predicate<Car> carPredicate) {
        return repository.getCars().stream().filter(carPredicate).collect(Collectors.toList());
    }
}
