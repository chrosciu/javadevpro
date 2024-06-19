package com.chrosciu.solid.liskov;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeslaVehicle {
    private final BaseVehicle baseVehicle;

    private boolean charged = false;

    public void chargeBatteries() {
        charged = true;
    }

    public void startEngine() {
        baseVehicle.startEngine();
    }

    public void ride() {
        if (!charged) {
            throw new IllegalStateException("Cannot ride on discharged batteries!");
        }
        baseVehicle.ride();
    }

    public void stopEngine() {
        baseVehicle.stopEngine();
    }
}
