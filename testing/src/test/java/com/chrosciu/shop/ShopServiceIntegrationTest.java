package com.chrosciu.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopServiceIntegrationTest {
    private ShopApplication shopApplication;

    @BeforeEach
    public void setUp() {
        shopApplication = new ShopApplication();
    }

    @Test
    public void shopServiceShouldBeCreated() {
        assertThat(shopApplication.getShopService()).isNotNull();
    }
}
