package com.chrosciu.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    public void shouldAllowToCopyItself() {
        Person person = new Person("Marcin", "Chrost", 40);
        Person personCopy = new Person(person);

        assertThat(personCopy).isNotSameAs(person);
        assertThat(personCopy).isEqualTo(person);
    }
}
