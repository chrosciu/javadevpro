package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WaxCarWash {
    private final Log log;
    
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
