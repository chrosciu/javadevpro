package com.chrosciu.patterns.behavioral.command;

import java.util.Stack;

class TextEditor {
    private final TextBuffer textBuffer = new TextBuffer();
    private final Stack<Command> commandHistory = new Stack<>();

    void appendText(String text) {
        execute(new AppendCommand(textBuffer, text));
    }

    void clearText() {
        execute(new ClearCommand(textBuffer));
    }

    void capitalizeText() {
        execute(new CapitalizeCommand(textBuffer));
    }

    private void execute(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    void undo() {
        var lastCommand = commandHistory.pop();
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }

    String getText() {
        return textBuffer.getText();
    }
}
