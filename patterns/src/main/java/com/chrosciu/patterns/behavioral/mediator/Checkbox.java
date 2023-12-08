package com.chrosciu.patterns.behavioral.mediator;

import lombok.Getter;
import lombok.Setter;

public class Checkbox {
    @Setter
    private Mediator mediator;
    @Getter
    private boolean checked = false;

    public void setChecked(boolean checked) {
        this.checked = checked;
        mediator.notify(new CheckboxChangeEvent(this));
    }
}
