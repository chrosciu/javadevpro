package com.chrosciu.patterns.structural.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HomeControlPanel {
    private final TemperatureController temperatureController;

    public void heat() {
        temperatureController.temperatureUp(20);
    }

    public void cool() {
        temperatureController.temperatureDown(10);
    }
}
