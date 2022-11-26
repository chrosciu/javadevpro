package com.chrosciu.patterns.structural.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AirConditioningToTemperatureAdapter implements TemperatureController {
    private final AirConditioningController airConditioningController;

    @Override
    public void temperatureUp(double deltaInCelsius) {
        airConditioningController.changeTemperature(TemperatureMapper.celsiusDeltaToFahrenheitDelta(deltaInCelsius));
    }

    @Override
    public void temperatureDown(double deltaInCelsius) {
        airConditioningController.changeTemperature(TemperatureMapper.celsiusDeltaToFahrenheitDelta(-deltaInCelsius));
    }
}
