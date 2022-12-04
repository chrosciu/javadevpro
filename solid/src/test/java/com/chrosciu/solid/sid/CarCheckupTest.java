package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.InMemoryLog;
import com.chrosciu.solid.utils.Log;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCheckupTest {
    private final Log log = new InMemoryLog();

    private final CarCheckLiquidsImpl carCheckLiquidsImpl = new CarCheckLiquidsImpl(log);
    private final CarVacuumImpl carVacuumImpl = new CarVacuumImpl(log);
    private final CarWashImpl carWashImpl = new CarWashImpl(log);
    private final CarCheckup carCheckup = new CarCheckup(carCheckLiquidsImpl, carVacuumImpl, carWashImpl);

    private final WaxCarWash waxCarWash = new WaxCarWash(log);
    private final CarCheckup waxCarCheckup = new CarCheckup(carCheckLiquidsImpl, carVacuumImpl, waxCarWash);

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
