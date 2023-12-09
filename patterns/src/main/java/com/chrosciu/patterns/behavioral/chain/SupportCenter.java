package com.chrosciu.patterns.behavioral.chain;

class SupportCenter {
    private final JuniorDeveloper juniorDeveloper = new JuniorDeveloper();

    SupportCenter() {
        RegularDeveloper regularDeveloper = new RegularDeveloper();
        juniorDeveloper.setSupervisor(regularDeveloper);
        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
        regularDeveloper.setSupervisor(seniorDeveloper);
    }

    String solve(Bug bug) {
        return juniorDeveloper.solve(bug);
    }
}
