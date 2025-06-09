package com.pic30f_experimentation_kit.com_controller.investigation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanisFamiliarisTest {

    @Test
    public void can_be_equal() {
        CanisFamiliaris canisFamiliaris1 = new CanisFamiliaris();
        CanisFamiliaris canisFamiliaris2 = new CanisFamiliaris();

        Assertions.assertEquals(canisFamiliaris1, canisFamiliaris2);
    }

    @Test
    public void can_be_not_equal() {
        CanisFamiliaris canisFamiliaris1 = new CanisFamiliaris();
        FelisCatus felisCatus = new FelisCatus();

        Assertions.assertNotEquals(canisFamiliaris1, felisCatus);
    }


}