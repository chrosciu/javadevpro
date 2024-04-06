package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.Log;

public abstract class AbstractVehicle {
    private final Log log = Log.getInstance();

    public void startEngine() {
        log.addMessage("Engine started");
    }

    abstract public void ride();

    public void stopEngine() {
        log.addMessage("Engine stopped");
    }
}
