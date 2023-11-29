package com.chrosciu.patterns.structural.composite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TextNode implements Node {
    private final String text;
}
