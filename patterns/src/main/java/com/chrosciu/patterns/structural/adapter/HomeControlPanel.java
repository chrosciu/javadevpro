package com.chrosciu.patterns.structural.adapter;

public class HomeControlPanel {
    private final TemperatureController temperatureController;

    public HomeControlPanel(TemperatureController temperatureController) {
        this.temperatureController = temperatureController;
    }

    public void heat() {
        temperatureController.temperatureUp(20);
    }

    public void cool() {
        temperatureController.temperatureDown(10);
    }
}
