package com.chrosciu.patterns.behavioral.chain;

class JuniorDeveloper {
    String solve(Bug bug) {
        if (bug.getSeverity().getRank() <= Severity.NORMAL.getRank()) {
            return "Solved by junior developer";
        }
        return "Not resolved - not enough skills";
    }
}
