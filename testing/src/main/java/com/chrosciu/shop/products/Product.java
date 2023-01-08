package com.chrosciu.shop.products;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.javamoney.moneta.FastMoney;

import java.util.Optional;

@Data
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private FastMoney price;
    @NonNull
    private ProductType type;

    public void setName(String name) {
        this.name = sanitizeName(name);
    }

    public static class ProductBuilder {
        private String name;

        public ProductBuilder name(String name) {
            this.name = sanitizeName(name);
            return this;
        }
    }

    private static String sanitizeName(String name) {
        return Optional.ofNullable(name)
                .map(n -> n.trim().replaceAll("\\s+", "_"))
                .orElse(null);
    }
}
