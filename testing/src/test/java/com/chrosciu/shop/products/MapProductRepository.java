package com.chrosciu.shop.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class MapProductRepository implements ProductRepository {
    @Getter
    @Setter
    private Map<Long, Product> productMap;

    private long id = 0;

    @Override
    public Product save(Product product) {
        product.setId(id++);
        productMap.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(productMap.values());
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(productMap.get(id));
    }
}
