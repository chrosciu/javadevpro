package com.chrosciu.patterns.behavioral.mediator;

import lombok.Getter;
import lombok.Setter;

public class Checkbox {
    @Setter
    private Input input;
    @Setter
    private Button button;
    @Getter
    private boolean checked = false;

    public void setChecked(boolean checked) {
        this.checked = checked;
        button.setEnabled(!checked || !input.getText().isBlank());
    }
}
