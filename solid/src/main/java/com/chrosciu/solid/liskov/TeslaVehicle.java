package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.Log;

public class TeslaVehicle extends AbstractVehicle {
    private final Log log = Log.getInstance();

    private boolean charged = false;

    public void chargeBatteries() {
        charged = true;
    }

    @Override
    public void ride() {
        if (!charged) {
            throw new IllegalStateException("Cannot ride on discharged batteries!");
        }
        log.addMessage("Let's ride!");
    }
}
