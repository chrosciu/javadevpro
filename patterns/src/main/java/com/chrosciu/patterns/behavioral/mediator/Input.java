package com.chrosciu.patterns.behavioral.mediator;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

class Input {
    @Setter
    private Mediator mediator;
    @Getter
    private String text = "";

    public void setText(@NonNull String text) {
        this.text = text;
        mediator.notify(new InputChangeEvent(this));
    }
}
