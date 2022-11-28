package com.chrosciu.solid.sid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCheckupTest {
    private final Log log = new InMemoryLog();
    private final CarLiquidsChecking carLiquidsChecking = new CarLiquidsCheck(log);
    private final CarVacuuming carVacuuming = new CarVacuum(log);
    private final CarWashing carWashing = new CarWash(log);
    private final CarWashing waxCarWashing = new WaxCarWash(log);
    private final CarCheckup carCheckup = new CarCheckup(carLiquidsChecking, carVacuuming, carWashing);
    private final CarCheckup waxCarCheckup = new CarCheckup(carLiquidsChecking, carVacuuming, waxCarWashing);

    @Test
    public void shouldPerformAllNeededActionsDuringCheckup() {
        carCheckup.performCheckup();

        assertThat(log.getMessages()).containsExactly(
                "Checking oil",
                "Checking windscreen washer",
                "Checking brake fluid",
                "Vacuuming dashboard",
                "Vacuuming seats",
                "Washing body",
                "Washing windows"
        );
    }

    @Test
    public void shouldAllowWaxingDuringCheckup() {
        waxCarCheckup.performCheckup();

        assertThat(log.getMessages()).containsExactly(
                "Checking oil",
                "Checking windscreen washer",
                "Checking brake fluid",
                "Vacuuming dashboard",
                "Vacuuming seats",
                "Washing body",
                "Washing windows",
                "Waxing body"
        );
    }
}
