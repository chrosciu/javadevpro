package com.chrosciu.patterns.structural.composite;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HtmlNode implements Node {
    @Getter
    private final String tagName;
    private List<Node> subNodes = new ArrayList<>();

    public HtmlNode(String tagName) {
        this.tagName = tagName;
    }

    public void addSubNodes(Node... nodes) {
        subNodes.addAll(Arrays.asList(nodes));
    }

    public List<Node> getSubNodes() {
        return Collections.unmodifiableList(subNodes);
    }

    @Override
    public String renderContentAsString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(tagName);
        stringBuilder.append(">");
        for (Node subNode: subNodes) {
            stringBuilder.append(subNode.renderContentAsString());
        }
        stringBuilder.append("</");
        stringBuilder.append(tagName);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}