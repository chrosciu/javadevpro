package com.chrosciu.patterns.structural.adapter;

public interface TemperatureController {

    void temperatureUp(double deltaInCelsius);

    void temperatureDown(double deltaInCelsius);

}
