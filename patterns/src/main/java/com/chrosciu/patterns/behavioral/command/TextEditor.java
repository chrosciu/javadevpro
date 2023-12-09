package com.chrosciu.patterns.behavioral.command;

class TextEditor {
    private final TextBuffer textBuffer = new TextBuffer();

    void appendText(String text) {
        textBuffer.setText(textBuffer.getText() + text);
    }

    void clearText() {
        textBuffer.setText("");
    }

    void capitalizeText() {
        textBuffer.setText(textBuffer.getText().toUpperCase());
    }

    void undo() {
        //TODO: Implement
    }

    String getText() {
        return textBuffer.getText();
    }
}
