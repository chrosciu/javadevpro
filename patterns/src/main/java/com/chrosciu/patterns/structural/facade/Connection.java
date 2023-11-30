package com.chrosciu.patterns.structural.facade;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Connection {
    private final String url;
    public void send(String sql) {
        System.out.printf("Sending command: %s\n", sql);
    }
}
