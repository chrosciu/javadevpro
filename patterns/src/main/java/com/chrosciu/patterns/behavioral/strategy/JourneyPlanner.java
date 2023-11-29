package com.chrosciu.patterns.behavioral.strategy;

public class JourneyPlanner {

    public double calculateJourneyDistance(VehicleType vehicleType, Point start, Point end) {
        var distanceCalculator = getDistanceCalculatorForVehicleType(vehicleType);
        return distanceCalculator.calculateDistance(start, end);
    }

    private DistanceCalculator getDistanceCalculatorForVehicleType(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR: return new CarDistanceCalculator();
            case TRAIN: return new TrainDistanceCalculator();
            case DRONE: return new DroneDistanceCalculator();
            default: throw new IllegalStateException("Unknown vehicle type");
        }
    }

}
