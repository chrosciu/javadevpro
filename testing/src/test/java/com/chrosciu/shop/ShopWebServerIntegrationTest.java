package com.chrosciu.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ShopApplicationExtension.class)
public class ShopWebServerIntegrationTest {
    @Test
    public void shopServiceShouldBeCreated() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/products"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        assertThat(response.body()).isEqualTo(
                "[Product(id=0, name=Spring_masterclass, description=Praktyczny kurs Spring framework, price=PLN 1500.00, type=VIDEO), " +
                        "Product(id=1, name=Spring_guide, description=Praktyczne cwiczenia do samodzielnego wykonania, price=PLN 200.00, type=BOOK)]"
        );
    }
}
