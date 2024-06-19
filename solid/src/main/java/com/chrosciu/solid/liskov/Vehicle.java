package com.chrosciu.solid.liskov;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Vehicle {
    private final BaseVehicle baseVehicle;

    public void startEngine() {
        baseVehicle.startEngine();
    }

    public void ride() {
        baseVehicle.ride();
    }

    public void stopEngine() {
        baseVehicle.stopEngine();
    }
}
