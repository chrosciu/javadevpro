package com.chrosciu.patterns.behavioral.observer;

import lombok.Getter;

class Button extends AbstractPublisher implements Subscriber {
    @Getter
    private boolean enabled = true;
    private boolean checkboxChecked = false;
    private String inputText = "";

    public void submit() {
        if (!enabled) {
            return;
        }
        notifyAllSubscribers(new ButtonSubmitEvent());
    }

    @Override
    public void notify(Object event) {
        if (event instanceof CheckboxChangeEvent) {
            CheckboxChangeEvent checkboxChangeEvent = (CheckboxChangeEvent)event;
            this.checkboxChecked = checkboxChangeEvent.isChecked();
            this.enabled = !checkboxChecked || !inputText.isBlank();
        } else if (event instanceof InputChangeEvent) {
            InputChangeEvent inputChangeEvent = (InputChangeEvent)event;
            this.inputText = inputChangeEvent.getText();
            this.enabled = !checkboxChecked || !inputText.isBlank();
        }
    }
}
