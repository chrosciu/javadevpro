package com.chrosciu.shop.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();
    private long id = 0;

    @Override
    public Product save(Product product) {
        product.setId(id++);
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }
}
