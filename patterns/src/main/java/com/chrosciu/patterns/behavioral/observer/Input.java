package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Delegate;

class Input implements Subscriber {
    @Delegate
    private final PublisherMixin publisherMixin = new PublisherMixin();

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
