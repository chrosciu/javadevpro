package com.chrosciu.shop;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ShopWebServer implements AutoCloseable {
    private final ShopService shopService;
    private final HttpServer server;

    @SneakyThrows
    public ShopWebServer(ShopService shopService) {
        this.shopService = shopService;
        server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/products", new ProductsHandler());
        server.start();
        System.out.println("Server started");
    }

    @Override
    public void close() {
        server.stop(0);
        System.out.println("Server stopped");
    }

    private class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = shopService.getProducts().toString();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
