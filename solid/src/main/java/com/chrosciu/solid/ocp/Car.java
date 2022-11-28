package com.chrosciu.solid.ocp;

import lombok.Value;

@Value
public class Car {
    String name;
    int price;
    Color color;
    double fuelUsage;
}
