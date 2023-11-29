package com.chrosciu.patterns.behavioral.templatemethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class Drink {
    protected final CoffeeMachine coffeeMachine;

    void prepare() {
        coffeeMachine.boilWater();
        addGranulate();
        addSugar();
        pourDrink();
    }

    protected abstract void addGranulate();

    protected void addSugar() {
        //NO-OP
    }

    protected void pourDrink() {
        coffeeMachine.pourDrink(250);
    }
}
