package com.chrosciu.cleancode.repetitions;

enum Shape {
    LINE("Section", 2),
    TRIANGLE("Triangle", 3),
    SQUARE("Square", 4);

    private final String name;
    private final int edges;

    Shape(String name, int edges) {
        this.name = name;
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

    public int getEdges() {
        return edges;
    }
}

class ShapeUtils {
    public String getName(Shape shape) {
        return shape.getName();
    }

    public int getNumberOfEdges(Shape shape) {
        return shape.getEdges();
    }
}

public class RepeatedLogic {
    public static void main(String[] args) {
        Shape shape = Shape.TRIANGLE;
        ShapeUtils shapeUtils = new ShapeUtils();
        System.out.println(shapeUtils.getName(shape));
        System.out.println(shapeUtils.getNumberOfEdges(shape));
    }
}
