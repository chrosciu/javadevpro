package com.chrosciu.patterns.behavioral.chain;

class RegularDeveloper extends Developer {
    @Override
    boolean canSolve(Bug bug) {
        return bug.getSeverity().getRank() <= Severity.MAJOR.getRank();
    }

    @Override
    String prepareResolution(Bug bug) {
        return "Solved by regular developer";
    }
}
