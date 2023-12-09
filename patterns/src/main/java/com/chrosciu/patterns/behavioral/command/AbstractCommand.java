package com.chrosciu.patterns.behavioral.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class AbstractCommand implements Command {
    protected final TextBuffer textBuffer;
    protected String backup = "";

    @Override
    public void execute() {
        backup = textBuffer.getText();
        doChangeOnBuffer();
    }

    abstract void doChangeOnBuffer();

    @Override
    public void undo() {
        textBuffer.setText(backup);
    }
}
