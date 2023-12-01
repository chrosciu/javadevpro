package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class CarLiquidsChecker implements CarLiquidsChecking {
    private final Log log = Log.getInstance();

    public void checkLiquids() {
        checkOil();
        checkWindscreenWasher();
        checkBrakeFluid();
    }

    private void checkOil() {
        log.addMessage("Checking oil");
    }

    private void checkWindscreenWasher() {
        log.addMessage("Checking windscreen washer");
    }

    private void checkBrakeFluid() {
        log.addMessage("Checking brake fluid");
    }


}
