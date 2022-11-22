package com.chrosciu.patterns.structural.adapter;

public class AirConditioningController {
    private double temperatureInFahrenheit;

    public AirConditioningController(double temperatureInFahrenheit) {
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }

    public void changeTemperature(double deltaInFahrenheit) {
        temperatureInFahrenheit += deltaInFahrenheit;
    }

    public double getTemperature() {
        return temperatureInFahrenheit;
    }
}
