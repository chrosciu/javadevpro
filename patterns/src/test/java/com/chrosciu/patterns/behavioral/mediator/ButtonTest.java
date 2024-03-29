package com.chrosciu.patterns.behavioral.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ButtonTest {
    private final Button button = new Button();
    private final Checkbox checkbox = new Checkbox();
    private final Input input = new Input();

    @BeforeEach
    void setUp() {
        button.setCheckbox(checkbox);
        button.setInput(input);
        checkbox.setInput(input);
        checkbox.setButton(button);
        input.setCheckbox(checkbox);
        input.setButton(button);
    }

    @Test
    void shouldBeEnabledByDefault() {
        //when / then
        assertThat(button.isEnabled()).isTrue();
    }

    @Test
    void shouldBeDisabledWithCheckedCheckboxAndBlankText() {
        //when
        checkbox.setChecked(true);

        //then
        assertThat(button.isEnabled()).isFalse();
    }

    @Test
    void shouldBeEnabledWithCheckedCheckboxAndSomeText() {
        //when
        checkbox.setChecked(true);
        input.setText("Marcin");

        //then
        assertThat(button.isEnabled()).isTrue();
    }

    @Test
    void shouldResetCheckboxInputAndSelfOnSubmit() {
        //when
        checkbox.setChecked(true);
        input.setText("Marcin");
        button.submit();

        //then
        assertThat(checkbox.isChecked()).isFalse();
        assertThat(input.getText()).isEqualTo("");
        assertThat(button.isEnabled()).isTrue();
    }

    @Test
    void shouldDoNothingOnSubmitIfDisabled() {
        //when
        checkbox.setChecked(true);
        input.setText("   ");
        button.submit();

        //then
        assertThat(checkbox.isChecked()).isTrue();
        assertThat(input.getText()).isEqualTo("   ");
        assertThat(button.isEnabled()).isFalse();
    }
}
