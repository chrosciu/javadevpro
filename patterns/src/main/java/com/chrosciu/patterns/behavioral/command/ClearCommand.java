package com.chrosciu.patterns.behavioral.command;

class ClearCommand extends AbstractCommand {
    public ClearCommand(TextBuffer textBuffer) {
        super(textBuffer);
    }

    @Override
    void doChangeOnBuffer() {
        textBuffer.setText("");
    }
}
