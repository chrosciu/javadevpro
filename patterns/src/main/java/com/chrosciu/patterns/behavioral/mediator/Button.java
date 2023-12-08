package com.chrosciu.patterns.behavioral.mediator;

import lombok.Getter;
import lombok.Setter;

public class Button {
    @Setter
    private Mediator mediator;
    @Getter
    private boolean enabled = true;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void submit() {
        mediator.notify(new ButtonSubmitEvent(this));
    }
}
