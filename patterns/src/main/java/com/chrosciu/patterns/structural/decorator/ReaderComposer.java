package com.chrosciu.patterns.structural.decorator;

public class ReaderComposer {
    private final boolean lowerCaseEnabled;
    private final boolean underscoreEnabled;

    public ReaderComposer(boolean lowerCaseEnabled, boolean underscoreEnabled) {
        this.lowerCaseEnabled = lowerCaseEnabled;
        this.underscoreEnabled = underscoreEnabled;
    }

    public Reader compose(Reader reader) {
        //TODO: Implement
        return reader;
    }

    //Hint for underscore operation: user String.replaceAll("\\s", "_")
}
