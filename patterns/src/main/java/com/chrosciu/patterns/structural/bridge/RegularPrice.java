package com.chrosciu.patterns.structural.bridge;

class RegularPrice extends Price {
    @Override
    String getPriceType() {
        return "regular";
    }
}
