package com.pic30f_experimentation_kit.com_controller.investigation;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class FelisCatus extends Animal {
    public FelisCatus() {
        super("Felis", "Catus");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FelisCatus other) {
            return super.equals(other);
        }
        return false;
    }

}
