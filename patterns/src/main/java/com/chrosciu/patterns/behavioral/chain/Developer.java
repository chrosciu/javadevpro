package com.chrosciu.patterns.behavioral.chain;

import lombok.Setter;

abstract class Developer {
    @Setter
    protected Developer supervisor;

    String solve(Bug bug) {
        if (canSolve(bug)) {
            return prepareResolution(bug);
        }
        if (supervisor != null) {
            return supervisor.solve(bug);
        }
        return "Not resolved";
    }

    abstract boolean canSolve(Bug bug);

    abstract String prepareResolution(Bug bug);
}
