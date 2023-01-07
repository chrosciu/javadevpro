package com.chrosciu.shop.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final long id;
}
