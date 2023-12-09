package com.chrosciu.patterns.behavioral.chain;

class SupportCenter {
    private final JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
    private final SeniorDeveloper seniorDeveloper = new SeniorDeveloper();

    String solve(Bug bug) {
        if (bug.getSeverity().getRank() <= Severity.NORMAL.getRank()) {
            return juniorDeveloper.solve(bug);
        } else {
            return seniorDeveloper.solve(bug);
        }
    }
}
