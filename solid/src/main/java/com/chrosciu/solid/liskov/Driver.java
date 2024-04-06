package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }

    public void drive(TeslaVehicle vehicle) {
        vehicle.startEngine();
        vehicle.chargeBatteries();
        vehicle.ride();
        vehicle.stopEngine();
    }
}
