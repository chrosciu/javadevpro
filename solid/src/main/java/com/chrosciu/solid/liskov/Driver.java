package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }

    public void driveTesla(TeslaVehicle vehicle) {
        vehicle.chargeBatteries();
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }
}
