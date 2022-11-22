package com.chrosciu.patterns.structural.adapter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeControlPanelTest {
    private final double initialTemperatureInFahrenheit = 32.0;
    private final AirConditioningController airConditioningController =
            new AirConditioningController(initialTemperatureInFahrenheit);

    //TODO: Create adapter class and use airConditioningController inside it to return TemperatureController
    private final TemperatureController temperatureController = null;

    private final HomeControlPanel homeControlPanel = new HomeControlPanel(temperatureController);

    @Test
    void heatTest() {
        homeControlPanel.heat();

        Assertions.assertThat(airConditioningController.getTemperature()).isEqualTo(68.0);
    }

    @Test
    void coolTest() {
        homeControlPanel.cool();

        Assertions.assertThat(airConditioningController.getTemperature()).isEqualTo(14.0);
    }

}
