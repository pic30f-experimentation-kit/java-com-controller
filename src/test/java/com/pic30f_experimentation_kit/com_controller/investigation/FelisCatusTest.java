package com.pic30f_experimentation_kit.com_controller.investigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FelisCatusTest {
    @Test
    public void can_do_something_nice() {
        Animal felisCatus1 = new FelisCatus();
        Animal felisCatus2 = new FelisCatus();

        Assertions.assertEquals(felisCatus1, felisCatus2);
    }
}