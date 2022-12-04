package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarVacuumImpl implements CarVacuum {
    private final Log log;

    @Override
    public void vacuum() {
        vacuumDashboard();
        vacuumSeats();
    }

    private void vacuumDashboard() {
        log.addMessage("Vacuuming dashboard");
    }

    private void vacuumSeats() {
        log.addMessage("Vacuuming seats");
    }
}
