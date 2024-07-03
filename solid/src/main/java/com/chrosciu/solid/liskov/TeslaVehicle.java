package com.chrosciu.solid.liskov;

import lombok.experimental.Delegate;

public class TeslaVehicle {
    @Delegate
    private final VehicleMixin vehicleMixin = new VehicleMixin();

    private boolean charged = false;

    public void chargeBatteries() {
        charged = true;
    }

    public void ride() {
        if (!charged) {
            throw new IllegalStateException("Cannot ride on discharged batteries!");
        }
        vehicleMixin.ride();
    }
}
