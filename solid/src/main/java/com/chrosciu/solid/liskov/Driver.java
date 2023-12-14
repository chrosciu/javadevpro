package com.chrosciu.solid.liskov;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.startEngine();
        vehicle.ride();
        vehicle.stopEngine();
    }

    public void driveTesla(TeslaVehicle teslaVehicle) {
        teslaVehicle.chargeBatteries();
        teslaVehicle.startEngine();
        teslaVehicle.ride();
        teslaVehicle.stopEngine();
    }
}
