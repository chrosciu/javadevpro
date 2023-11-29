package com.chrosciu.patterns.behavioral.strategy;

public class TrainDistanceCalculator implements DistanceCalculator {
    private static final Point INTERCHANGE = Point.of(0, 0);
    @Override
    public double calculateDistance(Point start, Point end) {
        boolean collinearWithInterchange = (0 == start.getX() * end.getY() - start.getY() * end.getX());
        if (collinearWithInterchange) {
            return start.distanceTo(end);
        } else {
            return start.distanceTo(INTERCHANGE) + INTERCHANGE.distanceTo(end);
        }
    }
}
