package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.NonNull;

class Input extends AbstractPublisher implements Subscriber {
    @Getter
    private String text = "";

    public void setText(@NonNull String text) {
        this.text = text;
        notifyAllSubscribers(new InputChangeEvent(text));
        //button.setEnabled(!checkbox.isChecked() || !text.isBlank());
    }

    @Override
    public void notify(Object event) {
        if (event instanceof ButtonSubmitEvent) {
            this.text = "";
        }
    }
}
