package com.chrosciu.patterns.creational.singleton;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

    @Test
    @SneakyThrows
    @Disabled("Multi thread tests are not 100% reliable")
    public void shouldReturnDifferentInstancesIfNotProperlySynchronized() {
        List<CompletableFuture<NonThreadSafeWeather>> promises = new ArrayList<>();
        Set<NonThreadSafeWeather> weathers = new HashSet<>();
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            promises.add(CompletableFuture.supplyAsync(() -> NonThreadSafeWeather.getInstance(weatherService), executor));
        }
        for (CompletableFuture<NonThreadSafeWeather> promise : promises) {
            weathers.add(promise.get());
        }
        assertThat(weathers).hasSizeGreaterThan(1);
    }

    @Test
    @SneakyThrows
    public void shouldReturnTheSameInstanceIfProperlySynchronized() {
        List<CompletableFuture<ThreadSafeWeather>> promises = new ArrayList<>();
        Set<ThreadSafeWeather> weathers = new HashSet<>();
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            promises.add(CompletableFuture.supplyAsync(() -> ThreadSafeWeather.getInstance(weatherService), executor));
        }
        for (CompletableFuture<ThreadSafeWeather> promise : promises) {
            weathers.add(promise.get());
        }
        assertThat(weathers).hasSize(1);
    }
}
