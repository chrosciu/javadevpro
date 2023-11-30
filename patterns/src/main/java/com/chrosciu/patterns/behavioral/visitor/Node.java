package com.chrosciu.patterns.behavioral.visitor;

interface Node {
    void accept(NodeVisitor nodeVisitor);
}
