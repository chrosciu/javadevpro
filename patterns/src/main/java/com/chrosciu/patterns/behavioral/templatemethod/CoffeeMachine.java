package com.chrosciu.patterns.behavioral.templatemethod;

import lombok.NonNull;

import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.TEA;

public class CoffeeMachine {

    protected enum Granulate {
        TEA,
        COFFEE
    }

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void addGranulate(@NonNull Granulate granulate) {
        System.out.printf("Adding %s granulate\n", granulate);
    }

    protected void addSugar(int spoons) {
        System.out.printf("Adding %d spoons of sugar\n", spoons);
    }

    protected void pourDrink(int amountInMl) {
        System.out.printf("Pouring %d ml of drink\n", amountInMl);
    }

    public void makeTea() {
        boilWater();
        addGranulate(TEA);
        addSugar(2);
        pourDrink(250);
    }

    public void makeBitterTea() {
        boilWater();
        addGranulate(TEA);
        pourDrink(250);
    }

    public void makeSmallCoffee() {
        //TODO: Implement
    }

    public void makeCoffee() {
        //TODO: Implement
    }
}
