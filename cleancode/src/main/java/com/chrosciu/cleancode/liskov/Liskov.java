package com.chrosciu.cleancode.liskov;

public class Liskov {

    static class Rectangle {
        protected int height;
        protected int width;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getArea() {
            return height * width;
        }
    }

    static class Square extends Rectangle {
        @Override
        public void setHeight(int height) {
            this.height = height;
            this.width = height;
        }

        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;
        }
    }

    public static void main(String[] args) {
        //Rectangle rectangle = new Rectangle();
        Rectangle rectangle = new Square();
        System.out.println(calculateArea(rectangle));
    }

    private static int calculateArea(Rectangle rectangle) {
        rectangle.setHeight(7);
        rectangle.setWidth(8);
        return rectangle.getArea();
    }

}
