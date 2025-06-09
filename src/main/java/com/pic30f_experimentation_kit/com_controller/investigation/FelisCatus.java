package com.pic30f_experimentation_kit.com_controller.investigation;

public class FelisCatus extends AnimalImpl {
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
