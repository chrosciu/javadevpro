package com.chrosciu.solid.sid;

public class CarCheckup {
    private final CarLiquidsChecking carLiquidsChecking;
    private final CarVacuuming carVacuuming;
    private final CarWashing carWashing;

    public CarCheckup(CarLiquidsChecking carLiquidsChecking, CarVacuuming carVacuuming, CarWashing carWashing) {
        this.carLiquidsChecking = carLiquidsChecking;
        this.carVacuuming = carVacuuming;
        this.carWashing = carWashing;
    }

    public void performCheckup() {
        carLiquidsChecking.checkLiquids();
        carVacuuming.vacuum();
        carWashing.wash();
    }
}
