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
    private HttpServer httpServer;

    @SneakyThrows
    public ShopWebServer(ShopService shopService) {
        this.shopService = shopService;
        System.out.println("Starting server");
        httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.createContext("/products", new ProductsHandler());
        httpServer.start();
        System.out.println("Server started");
    }

    @Override
    public void close() {
        System.out.println("Stopping server");
        httpServer.stop(0);
        System.out.println("Server stopped");
    }

    private class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String responseBody = "Hello World!";
            exchange.sendResponseHeaders(200, responseBody.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(responseBody.getBytes());
            outputStream.close();
        }
    }

    private class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = shopService.getProducts().toString();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}
