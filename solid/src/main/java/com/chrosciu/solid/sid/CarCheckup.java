package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class CarCheckup {
    private final CarService carService;

    public CarCheckup(Log log) {
        this.carService = new CarService(log);
    }

    public void performCheckup() {
        carService.checkLiquids();
        carService.vacuum();
        carService.wash();
    }
}
