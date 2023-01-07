package com.chrosciu.shop.products;

public interface ProductValidator {
    //if not valid - throw IllegalArgumentException
    void validate(Product product);
}
