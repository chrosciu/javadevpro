package com.chrosciu.patterns.structural.bridge;

class DiscountPrice extends Price {
    @Override
    String getPriceType() {
        return "discount";
    }
}
