package com.chrosciu.patterns.behavioral.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ButtonSubmitEvent implements Event {
    private final Button button;

    @Override
    public Button getSource() {
        return button;
    }
}
