package com.chrosciu.solid.ocp;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;

import static com.chrosciu.solid.ocp.Color.BLACK;
import static com.chrosciu.solid.ocp.Color.WHITE;
import static org.assertj.core.api.Assertions.assertThat;

public class CarSearchTest {
    private static final Car FIAT_PUNTO = new Car("Fiat Punto", 1000, BLACK, 5.5);
    private static final Car VW_PASSAT = new Car("VW Passat", 2000, WHITE, 6.5);
    private static final Car POLONEZ_CARO = new Car("Polonez Caro", 500, WHITE, 15.0);

    private final CarRepository carRepository = new InMemoryCarRepository(List.of(FIAT_PUNTO, VW_PASSAT, POLONEZ_CARO));
    private final CarSearch carSearch = new CarSearch(carRepository);

    @Test
    public void shouldBeAbleToPerformSearchByName() {
        List<Car> foundCars = carSearch.findByName("Fiat Punto");

        assertThat(foundCars).containsExactlyInAnyOrder(FIAT_PUNTO);
    }

    @Test
    public void shouldBeAbleToPerformSearchByMaxPrice() {
        List<Car> foundCars = carSearch.find(new CarMaxPricePredicate(1200));

        assertThat(foundCars).containsExactlyInAnyOrder(FIAT_PUNTO, POLONEZ_CARO);
    }

    @Test
    public void shouldBeAbleToPerformSearchByColors() {
        List<Car> foundCars = carSearch.find(new CarColorsPredicate(EnumSet.of(WHITE)));

        assertThat(foundCars).containsExactlyInAnyOrder(POLONEZ_CARO, VW_PASSAT);
    }

    @Test
    public void shouldBeAbleToPerformSearchByMaxPriceAndMaxFuelUsage() {
        List<Car> foundCars = carSearch.find(new CarMaxPricePredicate(1200)
                .and(new CarMaxFuelUsagePredicate(7.0)));

        assertThat(foundCars).containsExactlyInAnyOrder(FIAT_PUNTO);
    }

    @Test
    public void shouldBeAbleToPerformSearchByMaxPriceOrMaxFuelUsage() {
        List<Car> foundCars = carSearch.find(new CarMaxPricePredicate(1200)
                .or(new CarMaxFuelUsagePredicate(7.0)));

        assertThat(foundCars).containsExactlyInAnyOrder(FIAT_PUNTO, POLONEZ_CARO, VW_PASSAT);
    }


}
