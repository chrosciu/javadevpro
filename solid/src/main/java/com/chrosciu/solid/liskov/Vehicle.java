package com.chrosciu.solid.liskov;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class Vehicle implements VehicleBehavior {
    @Delegate
    private final BaseVehicle baseVehicle;
}
