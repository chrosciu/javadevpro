package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

class Input {
    @Setter
    private Checkbox checkbox;
    @Setter
    private Button button;
    @Getter
    private String text = "";

    public void setText(@NonNull String text) {
        this.text = text;
        button.setEnabled(!checkbox.isChecked() || !text.isBlank());
    }
}
