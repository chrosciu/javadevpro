package com.chrosciu.patterns.structural.facade;

class Dialect {
    String useDatabase(String databaseName) {
        return String.format("USE %s", databaseName);
    }
}
