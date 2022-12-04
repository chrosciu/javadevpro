package com.chrosciu.patterns.structural.decorator;

public class UnderscoreReaderDecorator extends ReaderDecorator {
    public UnderscoreReaderDecorator(Reader reader) {
        super(reader);
    }

    @Override
    public String getText() {
        return super.getText().replaceAll("\\s", "_");
    }
}
