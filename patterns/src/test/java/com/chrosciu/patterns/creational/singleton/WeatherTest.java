package com.chrosciu.patterns.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTest {
    private final WeatherService weatherService = new WeatherService() {
        @Override
        public double getTemperature() {
            return 10.5;
        }
    };

    @Test
    public void shouldReadTemperatureFromService() {
        Weather weather = Weather.getInstance(weatherService);

        assertThat(weather.getTemperature()).isEqualTo(10.5);
    }

    @Test
    public void shouldAlwaysReturnTheSameInstance() {
        Weather weather = Weather.getInstance(weatherService);
        Weather anotherWeather = Weather.getInstance(weatherService);

        assertThat(weather).isSameAs(anotherWeather);
    }
}
