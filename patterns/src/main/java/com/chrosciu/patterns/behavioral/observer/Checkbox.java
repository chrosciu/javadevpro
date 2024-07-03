package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;
import lombok.experimental.Delegate;

class Checkbox implements Subscriber {
    @Delegate
    private final PublisherMixin publisherMixin = new PublisherMixin();

    @Getter
    private boolean checked = false;

    public void setChecked(boolean checked) {
        this.checked = checked;
        notifyAllSubscribers(new CheckboxChangeEvent(checked));
        //button.setEnabled(!checked || !input.getText().isBlank());
    }

    @Override
    public void notify(Object event) {
        if (event instanceof ButtonSubmitEvent) {
            this.checked = false;
        }
    }
}
