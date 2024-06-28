package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.Log;

abstract public class AbstractVehicle {
    private final Log log = Log.getInstance();

    public void startEngine() {
        log.addMessage("Engine started");
    }

    public void ride() {
        log.addMessage("Let's ride!");
    }

    public void stopEngine() {
        log.addMessage("Engine stopped");
    }
}
