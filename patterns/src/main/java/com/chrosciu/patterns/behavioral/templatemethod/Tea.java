package com.chrosciu.patterns.behavioral.templatemethod;

import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.TEA;

class Tea extends Drink {
    public Tea(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    protected void addGranulate() {
        coffeeMachine.addGranulate(TEA);
    }

    @Override
    protected void addSugar() {
        coffeeMachine.addSugar(2);
    }

}
