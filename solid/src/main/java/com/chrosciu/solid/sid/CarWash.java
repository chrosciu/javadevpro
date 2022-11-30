package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarWash implements CarWashing {
    private final Log log;

    @Override
    public void wash() {
        washBody();
        washWindows();
    }

    private void washBody() {
        log.addMessage("Washing body");
    }

    private void washWindows() {
        log.addMessage("Washing windows");
    }
}
