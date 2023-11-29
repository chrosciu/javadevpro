package com.chrosciu.patterns.behavioral.strategy;

public class CarDistanceCalculator implements DistanceCalculator {
    @Override
    public double calculateDistance(Point start, Point end) {
        return Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
    }
}
