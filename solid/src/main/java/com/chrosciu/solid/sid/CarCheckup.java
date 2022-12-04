package com.chrosciu.solid.sid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarCheckup {
    private final CarCheckLiquids carCheckLiquids;
    private final CarVacuum carVacuum;
    private final CarWash carWash;

    public void performCheckup() {
        carCheckLiquids.checkLiquids();
        carVacuum.vacuum();
        carWash.wash();
    }
}
