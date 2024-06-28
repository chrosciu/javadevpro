package com.chrosciu.solid.sid;

import com.chrosciu.solid.utils.Log;

public class WaxCarWash implements CarServicing {
    private final Log log = Log.getInstance();

    @Override
    public void checkLiquids() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void vacuum() {
        throw new UnsupportedOperationException("Not supported yet.");
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
