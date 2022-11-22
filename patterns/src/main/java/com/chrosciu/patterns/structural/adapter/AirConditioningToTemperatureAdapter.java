package com.chrosciu.patterns.structural.adapter;

public class AirConditioningToTemperatureAdapter implements TemperatureController {
    private final AirConditioningController airConditioningController;

    public AirConditioningToTemperatureAdapter(AirConditioningController airConditioningController) {
        this.airConditioningController = airConditioningController;
    }

    @Override
    public void temperatureUp(double deltaInCelsius) {
        airConditioningController.changeTemperature(TemperatureMapper.celsiusDeltaToFahrenheitDelta(deltaInCelsius));
    }

    @Override
    public void temperatureDown(double deltaInCelsius) {
        airConditioningController.changeTemperature(TemperatureMapper.celsiusDeltaToFahrenheitDelta(-deltaInCelsius));
    }
}
