package com.chrosciu.solid.liskov;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;


@RequiredArgsConstructor
public class TeslaVehicle implements VehicleBehavior {
    @Delegate
    private final BaseVehicle baseVehicle;

    private boolean charged = false;

    public void chargeBatteries() {
        charged = true;
    }

    public void rideAsTesla() {
        if (!charged) {
            throw new IllegalStateException("Cannot ride on discharged batteries!");
        }
        baseVehicle.ride();
    }


}
