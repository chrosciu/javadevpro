package com.chrosciu.patterns.structural.facade;

class DatabaseClient {
    public static void main(String[] args) {
        var urlBuilder = new UrlBuilder();
        var url = urlBuilder.buildUrl("localhost", 5432);
        var connectionPool = new ConnectionPool();
        var connection = connectionPool.connect(url);
        var dialect = new Dialect();
        var sql = dialect.useDatabase("example");
        connection.send(sql);
    }
}
