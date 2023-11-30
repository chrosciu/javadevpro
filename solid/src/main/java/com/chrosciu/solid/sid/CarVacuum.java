package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class CarVacuum implements CarVacuuming {
    private final Log log = Log.getInstance();

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
