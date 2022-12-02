package com.chrosciu.cleancode.repetitions;

enum Shape {
    LINE,
    TRIANGLE,
    SQUARE
}

class ShapeUtils {
    public String getName(Shape shape) {
        switch (shape) {
            case LINE:
                return "Section";
            case TRIANGLE:
                return "Triangle";
            case SQUARE:
                return "Square";
        }
        throw new IllegalStateException("Should never happen");
    }

    public int getNumberOfEdges(Shape shape) {
        switch (shape) {
            case LINE:
                return 2;
            case TRIANGLE:
                return 3;
            case SQUARE:
                return 4;
        }
        throw new IllegalStateException("Should never happen");
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
