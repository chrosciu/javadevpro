package com.chrosciu.solid.liskov;

import lombok.experimental.Delegate;

public class Vehicle {
    @Delegate
    private final VehicleMixin vehicleMixin = new VehicleMixin();
}
