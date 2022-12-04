package com.chrosciu.patterns.structural.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReaderComposer {
    private final boolean lowerCaseEnabled;
    private final boolean underscoreEnabled;

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
