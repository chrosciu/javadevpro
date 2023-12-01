package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class WaxCarWash implements CarWashing {
    private final Log log = Log.getInstance();

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
