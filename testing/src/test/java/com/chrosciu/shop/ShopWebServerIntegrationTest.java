package com.chrosciu.shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ShopWebServerIntegrationTest {
    private ShopApplication shopApplication;

    @BeforeEach
    public void setUp() {
        shopApplication = new ShopApplication();
    }

    @AfterEach
    public void tearDown() {
        shopApplication.close();
    }

    @Test
    public void shouldRespondWithHelloWorld() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/hello"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertThat(response.body()).isEqualTo("Hello World!");
    }

    @Test
    public void shouldRespondWithAllProducts() {
        //TODO
    }
}
