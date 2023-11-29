package com.chrosciu.patterns.behavioral.templatemethod;

import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.TEA;

public class BitterTea extends Drink {
    public BitterTea(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    protected void addGranulate() {
        coffeeMachine.addGranulate(TEA);
    }
}
