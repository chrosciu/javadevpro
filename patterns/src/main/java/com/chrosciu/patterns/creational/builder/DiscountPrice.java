package com.chrosciu.patterns.creational.builder;

class DiscountPrice extends Price {
    @Override
    String getPriceType() {
        return "discount";
    }
}
