package com.chrosciu.patterns.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Animal implements Being {
    private final String name;

    @Override
    public Being copy() {
        return new Animal(name);
    }
}
