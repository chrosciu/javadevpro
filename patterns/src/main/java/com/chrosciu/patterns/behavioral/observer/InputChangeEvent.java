package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class InputChangeEvent {
    private final String text;
}
