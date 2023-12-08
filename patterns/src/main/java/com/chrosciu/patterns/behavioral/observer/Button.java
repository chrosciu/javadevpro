package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.Setter;

class Button {
    @Setter
    private Checkbox checkbox;
    @Setter
    private Input input;
    @Getter
    private boolean enabled = true;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void submit() {
        if (!enabled) {
            return;
        }
        checkbox.setChecked(false);
        input.setText("");
    }
}
