package com.chrosciu.patterns.structural.decorator;

public abstract class ReaderDecorator implements Reader {
    protected final Reader reader;

    public ReaderDecorator(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String getText() {
        return reader.getText();
    }
}
