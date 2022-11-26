package com.chrosciu.patterns.structural.adapter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeControlPanelTest {
    private final double initialTemperatureInFahrenheit = 32.0;
    private final AirConditioningController airConditioningController =
            new AirConditioningController(initialTemperatureInFahrenheit);

    private final TemperatureController temperatureController =
            new AirConditioningToTemperatureAdapter(airConditioningController);

    private final HomeControlPanel homeControlPanel = new HomeControlPanel(temperatureController);

    @Test
    void heatTest() {
        homeControlPanel.heat();

        Assertions.assertThat(airConditioningController.getTemperatureInFahrenheit()).isEqualTo(68.0);
    }

    @Test
    void coolTest() {
        homeControlPanel.cool();

        Assertions.assertThat(airConditioningController.getTemperatureInFahrenheit()).isEqualTo(14.0);
    }

}
