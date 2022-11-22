package com.chrosciu.patterns.structural.decorator;

public class ReaderComposer {
    private final boolean lowerCaseEnabled;
    private final boolean underscoreEnabled;

    public ReaderComposer(boolean lowerCaseEnabled, boolean underscoreEnabled) {
        this.lowerCaseEnabled = lowerCaseEnabled;
        this.underscoreEnabled = underscoreEnabled;
    }

    public Reader compose(Reader reader) {
        if (lowerCaseEnabled) {
            reader = new LowerCaseReaderDecorator(reader);
        }
        if (underscoreEnabled) {
            reader = new UnderscoreReaderDecorator(reader);
        }
        return reader;
    }
}
