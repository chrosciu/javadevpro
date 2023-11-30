package com.chrosciu.patterns.structural.facade;

class UrlBuilder {
    public String buildUrl(String host, int port) {
        return String.format("jdbc://%s:%d", host, port);
    }
}
