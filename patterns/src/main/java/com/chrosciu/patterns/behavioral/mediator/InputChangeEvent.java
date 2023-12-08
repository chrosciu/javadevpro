package com.chrosciu.patterns.behavioral.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class InputChangeEvent implements Event {
    private final Input input;

    @Override
    public Input getSource() {
        return input;
    }
}
