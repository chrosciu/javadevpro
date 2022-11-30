package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.Log;

public class TeslaVehicle extends Vehicle {
    public TeslaVehicle(Log log) {
        super(log);
    }

    private boolean charged = false;

    public void chargeBatteries() {
        charged = true;
    }

    @Override
    public void ride() {
        if (!charged) {
            throw new IllegalStateException("Cannot ride on discharged batteries!");
        }
        super.ride();
    }
}
