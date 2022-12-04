package com.chrosciu.solid.sid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarCheckup {
    private final CarService carService;

    public void performCheckup() {
        carService.checkLiquids();
        carService.vacuum();
        carService.wash();
    }
}
