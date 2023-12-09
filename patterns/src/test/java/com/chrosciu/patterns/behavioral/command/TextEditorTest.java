package com.chrosciu.patterns.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextEditorTest {
    private final TextEditor textEditor = new TextEditor();

    @Test
    void shouldBeEmptyByDefault() {
        //when / then
        assertThat(textEditor.getText()).isEmpty();
    }

    @Test
    void shouldContainAppendedText() {
        //when
        textEditor.appendText("Marcin ");
        textEditor.appendText("Chrost");

        //then
        assertThat(textEditor.getText()).isEqualTo("Marcin Chrost");
    }

    @Test
    void shouldClearText() {
        //when
        textEditor.appendText("Marcin");
        textEditor.clearText();

        //then
        assertThat(textEditor.getText()).isEmpty();
    }

    @Test
    void shouldCapitalizeText() {
        //when
        textEditor.appendText("Marcin");
        textEditor.capitalizeText();

        //then
        assertThat(textEditor.getText()).isEqualTo("MARCIN");
    }

    @Test
    void shouldUndoOperations() {
        //when
        textEditor.appendText("Marcin ");
        textEditor.capitalizeText();
        textEditor.appendText("Chrost");
        textEditor.clearText();
        textEditor.appendText("Tomasz");
        textEditor.undo();
        textEditor.undo();
        textEditor.undo();

        //then
        assertThat(textEditor.getText()).isEqualTo("MARCIN ");
    }
}
