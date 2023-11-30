package com.chrosciu.patterns.behavioral.visitor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class HtmlTree {
    private final HtmlNode root;

    public String renderContentAsString() {
        var nodeVisitor = new StringContentGeneratorNodeVisitor();
        root.accept(nodeVisitor);
        return nodeVisitor.getContent();
    }
}
