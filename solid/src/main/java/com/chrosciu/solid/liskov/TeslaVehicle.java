package com.chrosciu.solid.liskov;

public class TeslaVehicle extends AbstractVehicle {
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
