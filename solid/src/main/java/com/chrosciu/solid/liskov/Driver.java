package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }
}
