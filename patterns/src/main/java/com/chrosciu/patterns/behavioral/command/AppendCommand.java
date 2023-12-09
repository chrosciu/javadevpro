package com.chrosciu.patterns.behavioral.command;

public class AppendCommand extends AbstractCommand {
    private final String textToAppend;

    public AppendCommand(TextBuffer textBuffer, String textToAppend) {
        super(textBuffer);
        this.textToAppend = textToAppend;
    }

    @Override
    void doChangeOnBuffer() {
        textBuffer.setText(textBuffer.getText() + textToAppend);
    }
}
