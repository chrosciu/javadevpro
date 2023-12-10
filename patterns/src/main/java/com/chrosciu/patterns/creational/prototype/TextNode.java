package com.chrosciu.patterns.creational.prototype;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TextNode implements Node {
    private final String text;

    @Override
    public String toString() {
        return text;
    }

    @Override
    public Node copy() {
        return new TextNode(text);
    }
}
