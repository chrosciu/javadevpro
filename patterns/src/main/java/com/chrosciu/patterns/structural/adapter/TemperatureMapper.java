package com.chrosciu.patterns.structural.adapter;

public class TemperatureMapper {
    public static double celsiusToFahrenheit(Double celsius) {
        return celsius * 1.8 + 32;
    }

    public static double celsiusDeltaToFahrenheitDelta(Double celsiusDelta) {
        return celsiusDelta * 1.8;
    }
}
