package com.chrosciu.patterns.structural.facade;

class DatabaseFacade {
    public void connectToDatabase(String host, int port, String databaseName) {
        var urlBuilder = new UrlBuilder();
        var url = urlBuilder.buildUrl(host, port);
        var connectionPool = new ConnectionPool();
        var connection = connectionPool.connect(url);
        var dialect = new Dialect();
        var sql = dialect.useDatabase(databaseName);
        connection.send(sql);
    }
}
