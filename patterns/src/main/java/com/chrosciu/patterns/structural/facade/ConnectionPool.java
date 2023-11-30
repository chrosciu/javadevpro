package com.chrosciu.patterns.structural.facade;

class ConnectionPool {
    public Connection connect(String url) {
        System.out.printf("Creating connection with url: %s\n", url);
        return new Connection(url);
    }
}
