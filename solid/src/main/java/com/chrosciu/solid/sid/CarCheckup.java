package com.chrosciu.solid.sid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarCheckup {
    private final CarLiquidChecking carLiquidChecking;
    private final CarVacuuming carVacuuming;
    private final CarWashing carWashing;

    public void performCheckup() {
        carLiquidChecking.checkLiquids();
        carVacuuming.vacuum();
        carWashing.wash();
    }
}
