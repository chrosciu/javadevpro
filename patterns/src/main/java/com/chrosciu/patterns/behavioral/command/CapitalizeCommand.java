package com.chrosciu.patterns.behavioral.command;

class CapitalizeCommand extends AbstractCommand {
    public CapitalizeCommand(TextBuffer textBuffer) {
        super(textBuffer);
    }

    @Override
    void doChangeOnBuffer() {
        textBuffer.setText(textBuffer.getText().toUpperCase());
    }
}
