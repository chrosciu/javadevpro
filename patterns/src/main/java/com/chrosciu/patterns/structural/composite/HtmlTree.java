package com.chrosciu.patterns.structural.composite;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HtmlTree {
    private final HtmlNode root;

    public String renderContentAsString() {
        return root.renderContentAsString();
    }
}
