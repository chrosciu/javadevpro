package com.chrosciu.patterns.structural.composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HtmlTreeTest {

    @Test
    void shouldRenderContentAsString() {
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
        var htmlTree = new HtmlTree(rootNode);

        //when
        var content = htmlTree.renderContentAsString();

        //then
        assertThat(content).isEqualTo("<document>foo<div>bar<p>baz</p><p></p></div></document>");
    }


}
