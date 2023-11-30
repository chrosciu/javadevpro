package com.chrosciu.patterns.behavioral.visitor;

class StringContentGeneratorNodeVisitor implements NodeVisitor {
    private final StringBuilder contentBuilder = new StringBuilder();

    String getContent() {
        return contentBuilder.toString();
    }

    @Override
    public void visit(TextNode textNode) {
        contentBuilder.append(textNode.getText());
    }

    @Override
    public void visit(HtmlNode htmlNode) {
        contentBuilder.append("<");
        contentBuilder.append(htmlNode.getTagName());
        contentBuilder.append(">");
        for (Node node : htmlNode.getSubNodes()) {
            node.accept(this);
        }
        contentBuilder.append("</");
        contentBuilder.append(htmlNode.getTagName());
        contentBuilder.append(">");
    }
}
