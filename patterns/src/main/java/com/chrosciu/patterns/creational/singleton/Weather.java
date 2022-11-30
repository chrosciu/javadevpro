package com.chrosciu.patterns.creational.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Weather {
    private final double temperature;

    public static Weather getInstance(WeatherService weatherStation) {
        return new Weather(weatherStation.getTemperature());
    }
}
