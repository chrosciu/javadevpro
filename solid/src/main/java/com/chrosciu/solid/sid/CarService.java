package com.chrosciu.solid.sid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarService {
    private final Log log;

    public void checkLiquids() {
        checkOil();
        checkWindscreenWasher();
        checkBrakeFluid();
    }

    private void checkOil() {
        log.addMessage("Checking oil");
    }

    private void checkWindscreenWasher() {
        log.addMessage("Checking windscreen washer");
    }

    private void checkBrakeFluid() {
        log.addMessage("Checking brake fluid");
    }

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

    public void wash() {
        washBody();
        washWindows();
    }

    private void washBody() {
        log.addMessage("Washing body");
    }

    private void washWindows() {
        log.addMessage("Washing windows");
    }
}
