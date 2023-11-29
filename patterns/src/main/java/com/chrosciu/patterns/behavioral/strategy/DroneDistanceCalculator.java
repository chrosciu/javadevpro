package com.chrosciu.patterns.behavioral.strategy;

public class DroneDistanceCalculator implements DistanceCalculator {
    @Override
    public double calculateDistance(Point start, Point end) {
        return start.distanceTo(end);
    }
}
