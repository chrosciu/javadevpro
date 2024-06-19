package com.chrosciu.solid.ocp;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CarSearch {
    private final CarRepository repository;

//    public List<Car> findByName(String name) {
//        return repository.getCars().stream().filter(c -> name.equals(c.getName())).collect(Collectors.toList());
//    }

//    public List<Car> findByMaxPrice(int maxPrice) {
//        return repository.getCars().stream().filter(c -> c.getPrice() <= maxPrice).collect(Collectors.toList());
//    }

    public List<Car> findBy(Predicate<Car> carPredicate) {
        return repository.getCars().stream().filter(carPredicate).collect(Collectors.toList());
    }
}
