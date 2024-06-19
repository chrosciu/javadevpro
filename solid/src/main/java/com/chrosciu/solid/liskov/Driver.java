package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        if (vehicle instanceof TeslaVehicle) {
            TeslaVehicle teslaVehicle = (TeslaVehicle) vehicle;
            teslaVehicle.chargeBatteries();
        }
        vehicle.ride();
        vehicle.stopEngine();
    }
}
