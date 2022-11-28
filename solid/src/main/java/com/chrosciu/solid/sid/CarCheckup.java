package com.chrosciu.solid.sid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarCheckup {
    private final CarLiquidsChecking carLiquidsChecking;
    private final CarVacuuming carVacuuming;
    private final CarWashing carWashing;


    public void performCheckup() {
        carLiquidsChecking.checkLiquids();
        carVacuuming.vacuum();
        carWashing.wash();
    }
}
