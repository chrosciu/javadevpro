package com.chrosciu.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HtmlNode implements Node {
    private final String tagName;
    private List<Node> subNodes = new ArrayList<>();

    HtmlNode(String tagName) {
        this.tagName = tagName;
    }

    void addSubNodes(Node... nodes) {
        subNodes.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(tagName);
        stringBuilder.append(">");
        for (Node subNode : subNodes) {
            stringBuilder.append(subNode);
        }
        stringBuilder.append("</");
        stringBuilder.append(tagName);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    @Override
    public Node copy() {
        var node = new HtmlNode(tagName);
        node.addSubNodes(subNodes.toArray(new Node[0]));
        return node;
    }
}
