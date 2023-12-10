package com.chrosciu.patterns.creational.builder;

class RegularPrice extends Price {
    @Override
    String getPriceType() {
        return "regular";
    }
}
