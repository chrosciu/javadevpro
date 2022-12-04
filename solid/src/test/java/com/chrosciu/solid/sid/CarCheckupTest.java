package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.InMemoryLog;
import com.chrosciu.solid.utils.Log;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCheckupTest {
    private final Log log = new InMemoryLog();

    private final CarService carService = new CarServiceImpl(log);
    private final CarCheckup carCheckup = new CarCheckup(carService);

    private final CarService waxCarService = new WaxCarWash(log);
    private final CarCheckup waxCarCheckup = new CarCheckup(waxCarService);

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
