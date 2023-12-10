package com.chrosciu.patterns.structural.bridge;

class FlexPrice extends Price {
    @Override
    String getPriceType() {
        return "flex";
    }
}
