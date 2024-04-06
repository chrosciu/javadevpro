package com.chrosciu.solid.sid;

public class CarCheckup {
    private final CarServicing carServicing;

    public CarCheckup(CarServicing carServicing) {
        this.carServicing = carServicing;
    }

    public void performCheckup() {
        carServicing.checkLiquids();
        carServicing.vacuum();
        carServicing.wash();
    }
}
