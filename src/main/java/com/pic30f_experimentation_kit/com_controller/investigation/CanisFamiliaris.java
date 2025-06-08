package com.pic30f_experimentation_kit.com_controller.investigation;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class CanisFamiliaris extends Animal {
    public CanisFamiliaris() {
        super("Canis", "Familiaris");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CanisFamiliaris other) {
            return super.equals(other);
        }
        return false;
    }
}
