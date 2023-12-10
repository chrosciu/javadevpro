package com.chrosciu.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    void shouldCopyHtmlNode() {
        //given
        var rootNode = new HtmlNode("document");
        var textNode1 = new TextNode("foo");
        var div = new HtmlNode("div");
        var textNode2 = new TextNode("bar");
        var paragraph1 = new HtmlNode("p");
        var textNode3 = new TextNode("baz");
        var paragraph2 = new HtmlNode("p");
        paragraph1.addSubNodes(textNode3);
        div.addSubNodes(textNode2, paragraph1, paragraph2);
        rootNode.addSubNodes(textNode1, div);        

        //when
        var rootNodeCopy = rootNode.copy();

        //then
        assertThat(rootNodeCopy).isNotSameAs(rootNode);
        assertThat(rootNodeCopy.toString()).isEqualTo(rootNode.toString());
    }

    @Test
    void shouldCopyTextNode() {
        //given
        var textNode = new TextNode("Bar");

        //when
        var textNodeCopy = textNode.copy();

        //then
        assertThat(textNodeCopy).isNotSameAs(textNode);
        assertThat(textNodeCopy.toString()).isEqualTo(textNode.toString());
    }


}
