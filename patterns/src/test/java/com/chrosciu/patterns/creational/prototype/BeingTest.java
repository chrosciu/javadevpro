package com.chrosciu.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeingTest {
    @Test
    public void shouldAllowToCopyItselfForPerson() {
        Being being = new Person("Marcin", "Chrost", 40);
        Being beingCopy = null;

        assertThat(beingCopy).isEqualTo(being);
    }

    @Test
    public void shouldAllowToCopyItselfForAnimal() {
        Being being = new Animal("Maja");
        Being beingCopy = null;

        assertThat(beingCopy).isEqualTo(being);
    }
}
