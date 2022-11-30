package com.chrosciu.solid.liskov;

import com.chrosciu.solid.utils.InMemoryLog;
import com.chrosciu.solid.utils.Log;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {
    private final Log log = new InMemoryLog();
    private final Driver driver = new Driver();

    @Test
    public void shouldDriveVehicle() {
        Vehicle vehicle = new Vehicle(log);

        driver.drive(vehicle);

        assertThat(log.getMessages()).containsExactly("Engine started", "Let's ride!", "Engine stopped");
    }

    @Test
    public void shouldDriveTeslaVehicle() {
        Vehicle vehicle = new TeslaVehicle(log);

        driver.drive(vehicle);

        assertThat(log.getMessages()).containsExactly("Engine started", "Let's ride!", "Engine stopped");
    }
}
