package com.pic30f_experimentation_kit.com_controller.investigation;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Animal extends Object {
    private final String genus;
    private final String species;

    public Animal(String genus, String species) {
        this.genus = genus;
        this.species = species;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal other) {
            EqualsBuilder eb = new EqualsBuilder();

            eb.append(this.getGenus(), other.getGenus());
            eb.append(this.getSpecies(), other.getSpecies());

            return eb.isEquals();
        }
        return false;
    }

}
