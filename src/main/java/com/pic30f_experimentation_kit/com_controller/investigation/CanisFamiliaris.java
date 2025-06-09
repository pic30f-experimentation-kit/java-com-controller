package com.pic30f_experimentation_kit.com_controller.investigation;

public class CanisFamiliaris extends AnimalImpl {
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
