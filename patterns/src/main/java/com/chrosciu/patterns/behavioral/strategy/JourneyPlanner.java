package com.chrosciu.patterns.behavioral.strategy;

import static com.chrosciu.patterns.behavioral.strategy.VehicleType.CAR;
import static com.chrosciu.patterns.behavioral.strategy.VehicleType.DRONE;
import static com.chrosciu.patterns.behavioral.strategy.VehicleType.TRAIN;

public class JourneyPlanner {

    public double calculateJourneyDistance(VehicleType vehicleType, Point start, Point end) {
        if (CAR == vehicleType) {
            return Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
        } else if (TRAIN == vehicleType) {
            Point interchange = Point.of(0, 0);
            boolean collinearWithInterchange = 0 == start.getX() * end.getY() - start.getY() * end.getX();
            if (collinearWithInterchange) {
                return start.distanceTo(end);
            } else {
                return start.distanceTo(interchange) + interchange.distanceTo(end);
            }
        } else if (DRONE == vehicleType) {
            throw new RuntimeException("Drone distance not implemented yet");
        } else {
            throw new IllegalStateException("Unknown vehicle type");
        }
    }
}
