package com.chrosciu.patterns.creational.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
@Getter
@Log
public class NonThreadSafeWeather {
    private final double temperature;

    private static volatile NonThreadSafeWeather instance = null;

    @SneakyThrows
    public static NonThreadSafeWeather getInstance(WeatherService weatherStation) {
        if (null == instance) {
            Thread.sleep(1000);
            instance = new NonThreadSafeWeather(weatherStation.getTemperature());

        }
        return instance;
    }
}
