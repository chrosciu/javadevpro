package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.Log;

public class Vehicle extends AbstractVehicle {
    private final Log log = Log.getInstance();

    @Override
    public void ride() {
        log.addMessage("Let's ride!");
    }
}
