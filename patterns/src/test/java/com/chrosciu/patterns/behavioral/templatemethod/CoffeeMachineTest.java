package com.chrosciu.patterns.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.COFFEE;
import static com.chrosciu.patterns.behavioral.templatemethod.CoffeeMachine.Granulate.TEA;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;

public class CoffeeMachineTest {
    //given
    private CoffeeMachine coffeeMachine = spy(new CoffeeMachine());

    @Test
    void shouldMakeTea() {
        //when
        coffeeMachine.makeTea();

        //then
        var orderVerifier = inOrder(coffeeMachine);
        orderVerifier.verify(coffeeMachine).boilWater();
        orderVerifier.verify(coffeeMachine).addGranulate(TEA);
        orderVerifier.verify(coffeeMachine).addSugar(2);
        orderVerifier.verify(coffeeMachine).pourDrink(250);
        orderVerifier.verifyNoMoreInteractions();
    }

    @Test
    void shouldMakeBitterTea() {
        //when
        coffeeMachine.makeBitterTea();

        //then
        var orderVerifier = inOrder(coffeeMachine);
        orderVerifier.verify(coffeeMachine).boilWater();
        orderVerifier.verify(coffeeMachine).addGranulate(TEA);
        orderVerifier.verify(coffeeMachine, never()).addSugar(anyInt());
        orderVerifier.verify(coffeeMachine).pourDrink(250);
        orderVerifier.verifyNoMoreInteractions();
    }

    @Test
    void shouldMakeSmallCoffee() {
        //when
        coffeeMachine.makeSmallCoffee();

        //then
        var orderVerifier = inOrder(coffeeMachine);
        orderVerifier.verify(coffeeMachine).boilWater();
        orderVerifier.verify(coffeeMachine).addGranulate(COFFEE);
        orderVerifier.verify(coffeeMachine, never()).addSugar(anyInt());
        orderVerifier.verify(coffeeMachine).pourDrink(150);
        orderVerifier.verifyNoMoreInteractions();
    }

    @Test
    void shouldMakeCoffee() {
        //when
        coffeeMachine.makeCoffee();

        //then
        var orderVerifier = inOrder(coffeeMachine);
        orderVerifier.verify(coffeeMachine).boilWater();
        orderVerifier.verify(coffeeMachine).addGranulate(COFFEE);
        orderVerifier.verify(coffeeMachine, never()).addSugar(anyInt());
        orderVerifier.verify(coffeeMachine).pourDrink(250);
        orderVerifier.verifyNoMoreInteractions();
    }
}
