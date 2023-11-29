package com.chrosciu.patterns.behavioral.templatemethod;

import lombok.NonNull;

public class CoffeeMachine {

    enum Granulate {
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
        new Tea(this).prepare();
    }

    public void makeBitterTea() {
        new BitterTea(this).prepare();
    }

    public void makeSmallCoffee() {
        new SmallCoffee(this).prepare();
    }

    public void makeCoffee() {
        new Coffee(this).prepare();
    }
}
