package com.chrosciu.patterns.structural.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReaderComposer {
    private final boolean lowerCaseEnabled;
    private final boolean underscoreEnabled;

    public Reader compose(Reader reader) {
        //TODO: Implement
        return reader;
    }

    //Hint for underscore operation: user String.replaceAll("\\s", "_")
}
