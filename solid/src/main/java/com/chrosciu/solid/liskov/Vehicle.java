package com.chrosciu.solid.liskov;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final List<String> log = new ArrayList<>();

    public List<String> getLog() {
        return List.copyOf(log);
    }

    public void startEngine() {
        log.add("Engine started");
    }

    public void ride() {
        log.add("Let's ride!");
    }

    public void stopEngine() {
        log.add("Engine stopped");
    }
}
