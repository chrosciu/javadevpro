package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class CarService implements CarVacuuming, CarWashing {
    private final Log log = Log.getInstance();

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
