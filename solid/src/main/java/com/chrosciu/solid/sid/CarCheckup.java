package com.chrosciu.solid.sid;

public class CarCheckup {
    private final CarService carService;

    public CarCheckup() {
        this.carService = new CarService();
    }

    public void performCheckup() {
        carService.checkLiquids();
        carService.vacuum();
        carService.wash();
    }
}
