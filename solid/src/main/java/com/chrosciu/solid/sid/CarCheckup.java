package com.chrosciu.solid.sid;

public class CarCheckup {
    private final CarLiquidChecking carLiquidChecking;
    private final CarVacuuming carVacuuming;
    private final CarWashing carWashing;

    public CarCheckup(CarLiquidChecking carLiquidChecking, CarVacuuming carVacuuming, CarWashing carWashing) {
        this.carLiquidChecking = carLiquidChecking;
        this.carVacuuming = carVacuuming;
        this.carWashing = carWashing;
    }

    public void performCheckup() {
        carLiquidChecking.checkLiquids();
        carVacuuming.vacuum();
        carWashing.wash();
    }
}
