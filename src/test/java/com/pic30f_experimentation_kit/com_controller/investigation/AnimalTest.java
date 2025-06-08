package com.pic30f_experimentation_kit.com_controller.investigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    public void can_do_something_nice() {
        Animal animal = new Animal("Felis", "Catus");
        Assertions.assertEquals("Felis", animal.getGenus());
    }

}