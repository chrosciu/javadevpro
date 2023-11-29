package com.chrosciu.patterns.behavioral.templatemethod;

import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.COFFEE;

public class Coffee extends Drink {
    public Coffee(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    protected void addGranulate() {
        coffeeMachine.addGranulate(COFFEE);
    }
}
