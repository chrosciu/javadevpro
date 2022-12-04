package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.InMemoryLog;
import com.chrosciu.solid.utils.Log;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCheckupTest {
    private final Log log = new InMemoryLog();

    private final CarServiceImpl carServiceImpl = new CarServiceImpl(log);
    private final CarCheckup carCheckup = new CarCheckup(carServiceImpl, carServiceImpl, carServiceImpl);

    private final WaxCarWash waxCarWash = new WaxCarWash(log);
    private final CarCheckup waxCarCheckup = new CarCheckup(carServiceImpl, carServiceImpl, waxCarWash);

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
