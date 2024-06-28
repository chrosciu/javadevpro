package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }

    public void driveTesla(TeslaVehicle teslaVehicle) {
        teslaVehicle.startEngine();
        teslaVehicle.chargeBatteries();
        teslaVehicle.ride();
        teslaVehicle.stopEngine();
    }
}
