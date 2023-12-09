package com.chrosciu.patterns.behavioral.chain;

class SeniorDeveloper extends Developer {
    @Override
    boolean canSolve(Bug bug) {
        return true;
    }

    @Override
    String prepareResolution(Bug bug) {
        return "Solved by senior developer";
    }
}
