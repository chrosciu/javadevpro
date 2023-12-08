package com.chrosciu.patterns.behavioral.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class CheckboxChangeEvent implements Event {
    private final Checkbox checkbox;

    public Checkbox getSource() {
        return checkbox;
    }
}
