package com.chrosciu.solid.liskov;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {
    private final Driver driver = new Driver();

    @Test
    public void shouldDriveVehicle() {
        Vehicle vehicle = new Vehicle();

        driver.drive(vehicle);

        assertThat(vehicle.getLog()).containsExactly("Engine started", "Let's ride!", "Engine stopped");
    }

    @Test
    public void shouldDriveTeslaVehicle() {
        TeslaVehicle teslaVehicle = new TeslaVehicle();

        driver.driveTesla(teslaVehicle);

        assertThat(teslaVehicle.getLog()).containsExactly("Engine started", "Let's ride!", "Engine stopped");
    }
}
