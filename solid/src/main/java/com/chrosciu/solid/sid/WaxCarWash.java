package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WaxCarWash implements CarService {
    private final Log log;

    @Override
    public void checkLiquids() {
        throw new UnsupportedOperationException("Cannot check liquids!");
    }

    @Override
    public void vacuum() {
        throw new UnsupportedOperationException("Cannot vacuum!");
    }

    @Override
    public void wash() {
        washBody();
        washWindows();
        waxBody();
    }

    private void washBody() {
        log.addMessage("Washing body");
    }

    private void washWindows() {
        log.addMessage("Washing windows");
    }

    private void waxBody() {
        log.addMessage("Waxing body");
    }
}
