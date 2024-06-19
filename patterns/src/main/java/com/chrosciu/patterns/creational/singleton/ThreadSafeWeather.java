package com.chrosciu.patterns.creational.singleton;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
@Getter
@Log
public class ThreadSafeWeather {
    private final double temperature;

    private static volatile ThreadSafeWeather instance = null;

    //https://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html

    @SneakyThrows
    public static ThreadSafeWeather getInstance(WeatherService weatherStation) {
        if (null == instance) {
            synchronized (ThreadSafeWeather.class) {
                if (null == instance) {
                    Thread.sleep(1000);
                    instance = new ThreadSafeWeather(weatherStation.getTemperature());
                }
            }
        }
        return instance;
    }
}
