package com.chrosciu.patterns.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AirConditioningController {
    private double temperatureInFahrenheit;

    public void changeTemperature(double deltaInFahrenheit) {
        temperatureInFahrenheit += deltaInFahrenheit;
    }
}
