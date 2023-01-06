package com.chrosciu.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ShopApplicationExtension.class)
public class ShopServiceIntegrationTest {
    @Test
    public void shopServiceShouldBeCreated(ShopApplication shopApplication) {
        assertThat(shopApplication.getShopService()).isNotNull();
    }

    @Test
    public void shopServiceShouldBeCreated2(ShopApplication shopApplication) {
        assertThat(shopApplication.getShopService()).isNotNull();
    }
}
