package com.chrosciu.patterns.behavioral.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class FormMediator implements Mediator {
    private final Checkbox checkbox;
    private final Input input;
    private final Button button;
    @Override
    public void notify(Event event) {
        if (event instanceof CheckboxChangeEvent && event.getSource() == checkbox) {
            button.setEnabled(!checkbox.isChecked() || !input.getText().isBlank());
        } else if (event instanceof InputChangeEvent && event.getSource() == input) {
            button.setEnabled(!checkbox.isChecked() || !input.getText().isBlank());
        } else if (event instanceof ButtonSubmitEvent && event.getSource() == button) {
            if (button.isEnabled()) {
                checkbox.setChecked(false);
                input.setText("");
            }
        }
    }
}
