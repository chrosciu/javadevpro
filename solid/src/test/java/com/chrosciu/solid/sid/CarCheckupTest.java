package com.chrosciu.solid.sid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarCheckupTest {
    private final Log log = new InMemoryLog();
    private final CarCheckup carCheckup = new CarCheckup(log);

    @Test
    public void shouldPerformAllNeededActionsDuringCheckup() {
        carCheckup.performCheckup();

        Assertions.assertThat(log.getMessages()).containsExactly(
                "Checking oil",
                "Checking windscreen washer",
                "Checking brake fluid",
                "Vacuuming dashboard",
                "Vacuuming seats",
                "Washing body",
                "Washing windows"
        );
    }
}
