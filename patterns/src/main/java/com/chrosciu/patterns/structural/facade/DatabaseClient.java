package com.chrosciu.patterns.structural.facade;

class DatabaseClient {
    public static void main(String[] args) {
        var databaseFacade = new DatabaseFacade();
        databaseFacade.connectToDatabase("localhost", 5432, "example");
    }
}
