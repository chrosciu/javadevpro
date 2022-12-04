package com.chrosciu.patterns.creational.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
@Getter
public class Weather {
    private final double temperature;
    private static Weather instance;

    public static Weather getInstance(WeatherService weatherStation) {
        if (null == instance) {
            instance = new Weather(weatherStation.getTemperature());
        }
        return instance;
    }
}
