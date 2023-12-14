package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCheckupTest {
    private final Log log = Log.getInstance();
    private final CarLiquidsChecking carLiquidsChecking = new CarLiquidsCheck();
    private final CarVacuuming carVacuuming = new CarVacuum();
    private final CarWashing carWashing = new CarWash();
    private final CarWashing waxCarWashing = new WaxCarWash();
    private final CarCheckup carCheckup = new CarCheckup(carLiquidsChecking, carVacuuming, carWashing);
    private final CarCheckup waxCarCheckup = new CarCheckup(carLiquidsChecking, carVacuuming, waxCarWashing);

    @AfterEach
    void cleanUp() {
        log.clearMessages();
    }

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
