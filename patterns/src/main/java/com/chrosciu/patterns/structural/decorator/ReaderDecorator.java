package com.chrosciu.patterns.structural.decorator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ReaderDecorator implements Reader {
    private final Reader reader;

    @Override
    public String getText() {
        return reader.getText();
    }
}
